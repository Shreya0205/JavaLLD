import java.awt.*;
import java.util.ArrayList;

public class TicTacToe {

    Player player1;
    Player player2;
    Grid grid;
    private static TicTacToe ticTacToe = null;
    Player currentPlayer;

    private TicTacToe(String name1, String name2){
        this.grid = new Grid();
        this.player1 = new Player(name1, 'X', this.grid);
        this.player2 = new Player(name2, 'O', this.grid);
        this.currentPlayer = this.player1;
    }

    public synchronized static TicTacToe getInstance(String name1, String name2){
        if(ticTacToe == null){
            ticTacToe = new TicTacToe(name1, name2);
        }
        return ticTacToe;
    }

//    public void intialise(){
//        this.grid = new Grid();
//        this.player1 = new Player(this.player1.name, 'X', this.grid);
//        this.player2 = new Player(name2, 'O', this.grid);
//        this.currentPlayer = this.player1;
//    }

    public void displayGrid(){
        this.grid.displayGrid();
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public void changeState(){
        if(currentPlayer == player1)
            this.currentPlayer = player2;
        else{
            this.currentPlayer = player1;
        }
    }

    Boolean checkWinner(int row, int col){
        Character symbol = this.currentPlayer.symbol;
        ArrayList<ArrayList<Character>> matrix =  this.ticTacToe.grid.getMatrix();
        int count = 0;

        for(int i=0;i<3;i++){
            if(matrix.get(row-1).get(i) == symbol)
                count++;
        }

        if(count==3)
            return true;
        count=0;


        for(int i=0;i<3;i++){
            if(matrix.get(i).get(col-1) == symbol)
                count++;
        }

        if(count==3)
            return true;
        count=0;

        for(int i=0;i<3;i++){
            if(matrix.get(i).get(i) == symbol)
                count++;
        }

        if(count==3)
            return true;

        count=0;

        for(int i=0;i<3;i++){
            if(matrix.get(i).get(2-i) == symbol)
                count++;
        }

        if(count==3)
            return true;

        return false;


    }

    void compute(int row, int col){
        if(!checkWinner(row, col)){
//            if(row==3 && col==3)
//            System.out.println(this.grid.filledCells);
            if(this.grid.filledCells == 9){
                System.out.println("Game is draw");
            }
        }
        else
            System.out.println("Winner is "+ this.currentPlayer.name);

    }

    public void makeMove(Player player, int row, int col){
        if(player != this.currentPlayer) {
            System.out.println("Not a valid player to take turn");
            return;
        }
        this.currentPlayer.makeMove(row, col);
        this.compute(row, col);
        this.changeState();
    }




}
