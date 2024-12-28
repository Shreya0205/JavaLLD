package Code.services;

import Code.models.Inning;
import Code.models.Match;
import Code.models.Scorecard;
import Code.models.Team;

public class ScorecardService {
    private static ScorecardService instance;

    private ScorecardService() {}

    public static ScorecardService getInstance() {
        if (instance == null) {
            instance = new ScorecardService();
        }
        return instance;
    }

    public void updateInningsScore(Inning innings, int runs, int wickets) {
        innings.incrementRuns(runs);
        while (wickets-- > 0) {
            innings.incrementWickets();
        }
    }

    public void createInnings(Scorecard scorecard, Team battingTeam, Team bowlingTeam) {
        Inning inning = new Inning(scorecard.getInningsList().size() + 1, battingTeam, bowlingTeam);
        scorecard.addInnings(inning);
    }

    public Scorecard getScorecardForMatch(Match match) {
        return match.getScorecard();
    }

}
