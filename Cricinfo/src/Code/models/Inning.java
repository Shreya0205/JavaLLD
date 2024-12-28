package Code.models;

import java.util.ArrayList;
import java.util.List;

public class Inning {

    Integer id;
    Team BattingTeam;
    Team BallingTeam;
    List<Over> overs;
    Integer totalRuns;
    Integer totalWickets;

    public Inning(Integer id, Team battingTeam, Team ballingTeam) {
        this.id = id;
        BattingTeam = battingTeam;
        BallingTeam = ballingTeam;
        overs = new ArrayList<>();
        totalWickets = 0;
        totalRuns = 0;
    }

    public void addOver(Over over){
        this.overs.add(over);
    }

    public Integer getInningId() {
        return id;
    }

    public Team getBattingTeam() {
        return BattingTeam;
    }

    public Team getBallingTeam() {
        return BallingTeam;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void incrementRuns(int runs) {
        totalRuns += runs;
    }

    public void incrementWickets() {
        totalWickets += 1;
    }

    @Override
    public String toString() {
        return "Inning{" +
                "id=" + id +
                ", BattingTeam=" + BattingTeam.name +
                ", BallingTeam=" + BallingTeam.name +
                ", overs=" + overs +
                ", totalRuns=" + totalRuns +
                ", totalWickets=" + totalWickets +
                '}';
    }
}
