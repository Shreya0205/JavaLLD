//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = TicTacToe.getInstance("Shreya", "Asha");
        Player player1 = ticTacToe.getPlayer1();
        Player player2 = ticTacToe.getPlayer2();

//        ticTacToe.makeMove(player1, 1, 1);
//        ticTacToe.makeMove(player2, 1, 3);
//        ticTacToe.makeMove(player1, 3, 1);
//        ticTacToe.makeMove(player2, 2, 2);
//        ticTacToe.makeMove(player1, 2, 1);
//        ticTacToe.displayGrid();
//
//        ticTacToe.intialise();
        ticTacToe.displayGrid();

        ticTacToe.makeMove(player1, 1, 1);
        ticTacToe.makeMove(player2, 1, 2);
        ticTacToe.makeMove(player1, 1, 3);
        ticTacToe.makeMove(player2, 2, 2);
        ticTacToe.makeMove(player1, 2, 1);
        ticTacToe.makeMove(player2, 2, 3);
        ticTacToe.makeMove(player1, 3, 2);
        ticTacToe.makeMove(player2, 3, 1);
        ticTacToe.makeMove(player1, 3, 3);
        ticTacToe.displayGrid();
    }
}