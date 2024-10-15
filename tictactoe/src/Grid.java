import java.util.ArrayList;

public class Grid {

    ArrayList<ArrayList<Character>> matrix;
    Integer filledCells;

    public Grid(){
        this.matrix = new ArrayList<>(3);

        for(int i=0;i<3;i++){
            ArrayList<Character> row = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                row.add('-');
            }
            this.matrix.add(row);
        }

        this.filledCells = 0;
    }

    public void setBlock(Character symbol, int row, int col){
        this.matrix.get(row-1).set(col-1, symbol);
        this.filledCells=this.filledCells+1;
    }

    public ArrayList<ArrayList<Character>> getMatrix(){
        return this.matrix;
    }

    public void displayGrid(){
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                System.out.print(this.matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
