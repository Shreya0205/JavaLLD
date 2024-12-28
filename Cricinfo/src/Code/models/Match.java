package Code.models;

import java.time.LocalDateTime;

public class Match {

    Integer ID;
    Scorecard scorecard;
    LocalDateTime startTime;
    LocalDateTime endTime;
    MatchStatus matchStatus;
    Team team1;
    Team team2;

    public Match(Integer ID, LocalDateTime startTime, Team team1, Team team2) {
        this.ID = ID;
        this.startTime = startTime;
        this.team1 = team1;
        this.team2 = team2;
        scorecard = new Scorecard(team1, team2);
        matchStatus = MatchStatus.scheduled;
    }

    public Integer getID() {
        return ID;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setEndTime() {
        this.endTime = LocalDateTime.now();
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public void startMatch(){
        matchStatus = MatchStatus.started;
    }

    public void endMatch(){
        matchStatus = MatchStatus.started;
        setEndTime();
    }
}
