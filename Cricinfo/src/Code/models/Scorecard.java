package Code.models;

import java.util.ArrayList;
import java.util.List;

public class Scorecard {

    Team team1;
    Team team2;
    private List<Inning> inningsList;

    public Scorecard(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.inningsList = new ArrayList<>();
    }

    public void addInnings(Inning inning) {
        this.inningsList.add(inning);
    }

    public List<Inning> getInningsList() {
        return inningsList;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @Override
    public String toString() {
        return "Scorecard{" +
                "team1=" + team1 +
                ", team2=" + team2 +
                ", inningsList=" + inningsList.toString() +
                '}';
    }
}
