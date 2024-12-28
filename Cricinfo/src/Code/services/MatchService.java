package Code.services;

import Code.models.Match;
import Code.models.MatchStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class MatchService {
    private static MatchService instance;
    private HashMap<Integer, Match> matches;

    private MatchService() {
        matches = new HashMap<>();
    }

    public static MatchService getInstance() {
        if (instance == null) {
            instance = new MatchService();
        }
        return instance;
    }

    public void addMatch(Match match) {
        matches.put(match.getID(), match);
    }

    public Match getMatchById(Integer id) {
        return matches.get(id);
    }

    public void updateMatchStatus(Integer matchId, MatchStatus status) {
        Match match = getMatchById(matchId);
        if (match != null) {
            match.setMatchStatus(status);
        }
    }

    public void endMatch(Integer matchId){
        Match match = getMatchById(matchId);
        if (match != null) {
            match.setMatchStatus(MatchStatus.ended);
        }
    }
}
