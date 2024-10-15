public class Player {

    String name;
    Character symbol;

    private Grid grid;

    public Player(String name, Character symbol, Grid grid){
        this.name =  name;
        this.symbol = symbol;
        this.grid = grid;
    }

    void makeMove(int row, int col){
        this.grid.setBlock(this.symbol, row, col);
    }

}
