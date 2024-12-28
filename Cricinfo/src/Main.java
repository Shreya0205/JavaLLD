import Code.models.Ball.*;
import Code.models.Player;
import Code.models.PlayerRole;
import Code.models.Scorecard;
import Code.models.Team;
import Code.services.CricInfoSystem;

import java.time.LocalDateTime;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CricInfoSystem system = new CricInfoSystem();

        Player player1 = system.createPlayer(1, "Virat Kohli", PlayerRole.batsman);
        Player player2 = system.createPlayer(2, "Rohit Sharma", PlayerRole.batsman);
        Player player3 = system.createPlayer(3, "Jasprit Bumrah", PlayerRole.bowler);
        Team team1 = new Team(1, "India", Arrays.asList(player1, player2, player3));

        Player player4 = system.createPlayer(4, "David Warner", PlayerRole.batsman);
        Player player5 = system.createPlayer(5, "Pat Cummins", PlayerRole.bowler);
        Player player6 = system.createPlayer(6, "Shubham gill", PlayerRole.batsman);
        Team team2 = new Team(2, "Australia", Arrays.asList(player4, player5, player6));

        system.createMatch(1, LocalDateTime.now(), team1, team2);

        system.startMatch(1);

        system.addInningsToScorecard(1, team1, team2);

        system.addOverToInnings(1, team1, team2, 1);

        system.addBallToOver(1, 1, 1, player3, player1, new RunOutcome(BallOutcomeType.runs, 4));
        system.addBallToOver(1, 1, 2, player3, player1, new RunOutcome(BallOutcomeType.runs, 4));
        system.addBallToOver(1, 1, 3, player3, player2, new OutOutcome(BallOutcomeType.wicket, player3, OutType.bowled));

        system.updateInningsScore(1, 250, 2);

        Scorecard scorecard = system.getMatchScorecard(1);
        System.out.println("Match Scorecard: " + scorecard.toString());

        system.endMatch(1);
    }
}