import Code.Game;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        game.addPlayer("Shreya");
        game.addPlayer("Sonal");
        game.addPlayer("Asha");

        game.startGame();

    }
}