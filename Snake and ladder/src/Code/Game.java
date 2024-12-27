package Code;

import java.util.*;

public class Game {

    Board board;
    Dice dice;
    Queue<Player> players;
    Player winner;

    public Game() {
        this.board = new Board();
        this.dice = new Dice(6);
        this.players = new LinkedList<>();
        this.winner = null;
    }

    public void addPlayer(String name){
        Player player = new Player(name);
        this.players.add(player);
    }

    public void startGame(){

        while(winner == null){

            Player currentPlayer = players.poll();
            assert currentPlayer != null;

            int rolledNumber = dice.rollDice();
            System.out.println(currentPlayer.getName() + " rolled: " + rolledNumber);

            int newPosition = board.movePlayer(currentPlayer, rolledNumber);

            if (newPosition == 100) {
                winner = currentPlayer;
                break;
            }

            players.offer(currentPlayer);

        }

        System.out.println("Winner is: " + winner.getName());

    }



}
