package Code.services;

import Code.models.*;
import Code.models.Ball.Ball;
import Code.models.Ball.BallOutcome;

import java.time.LocalDateTime;

public class CricInfoSystem {

    private MatchService matchService;
    private ScorecardService scorecardService;
    private PlayerService playerService;

    public CricInfoSystem() {
        matchService = MatchService.getInstance();
        scorecardService = ScorecardService.getInstance();
        playerService = PlayerService.getInstance();
    }

    public Player createPlayer(Integer id, String name, PlayerRole role) {
        return playerService.createPlayer(id, name, role);
    }

    public Player getPlayerById(Integer id) {
        return playerService.getPlayerById(id);
    }

    public void createMatch(Integer matchId, LocalDateTime startTime, Team team1, Team team2) {
        Match match = new Match(matchId, startTime, team1, team2);
        matchService.addMatch(match);
    }

    public void startMatch(Integer matchId) {
        Match match = matchService.getMatchById(matchId);
        if (match != null && match.getMatchStatus() == MatchStatus.scheduled) {
            match.startMatch();
            System.out.println("Match started: " + matchId);
        }
    }

    public void endMatch(Integer matchId) {
        Match match = matchService.getMatchById(matchId);
        if (match != null && match.getMatchStatus() == MatchStatus.started) {
            match.endMatch();
            System.out.println("Match ended: " + matchId);
        }
    }

    public void addInningsToScorecard(Integer matchId, Team battingTeam, Team bowlingTeam) {
        Match match = matchService.getMatchById(matchId);
        if (match != null) {
            Scorecard scorecard = scorecardService.getScorecardForMatch(match);
            scorecardService.createInnings(scorecard, battingTeam, bowlingTeam);
            System.out.println("Innings added to match: " + matchId);
        }
    }

    public Scorecard getMatchScorecard(Integer matchId) {
        Match match = matchService.getMatchById(matchId);
        if (match != null) {
            return match.getScorecard();
        }
        return null;
    }

    public void updateInningsScore(Integer matchId, int runs, int wickets) {
        Match match = matchService.getMatchById(matchId);
        if (match != null) {
            Scorecard scorecard = scorecardService.getScorecardForMatch(match);
            Inning innings = scorecard.getInningsList().get(scorecard.getInningsList().size() - 1);
            scorecardService.updateInningsScore(innings, runs, wickets);
            System.out.println("Innings score updated for match: " + matchId);
        }
    }

    public void addOverToInnings(Integer matchId, Team battingTeam, Team bowlingTeam, int overNumber) {
        Match match = matchService.getMatchById(matchId);
        if (match != null) {
            Scorecard scorecard = scorecardService.getScorecardForMatch(match);
            Inning innings = scorecard.getInningsList().get(scorecard.getInningsList().size() - 1);
            Over over = new Over(overNumber);
            innings.addOver(over);
            System.out.println("Over added to innings for match: " + matchId);
        }
    }

    public void addBallToOver(Integer matchId, int overNumber, int ballNumber, Player bowler, Player batsman, BallOutcome outcome) {
        Match match = matchService.getMatchById(matchId);
        if (match != null) {
            Scorecard scorecard = scorecardService.getScorecardForMatch(match);
            Inning innings = scorecard.getInningsList().get(scorecard.getInningsList().size() - 1);
            Over over = innings.getOvers().stream()
                    .filter(o -> o.getOverNumber() == overNumber)
                    .findFirst()
                    .orElse(null);

            if (over != null) {
                Ball ball = new Ball(ballNumber, bowler, batsman, outcome);
                over.addBall(ball);
                System.out.println("Ball added to over: " + overNumber + " for match: " + matchId);
            }
        }
    }


}

