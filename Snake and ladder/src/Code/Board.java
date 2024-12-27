package Code;

import java.util.HashMap;

public class Board {

    HashMap<Integer, Cell> cells;

    public Board() {
        this.cells = new HashMap<>();

        for(int i=1;i<=100;i++){
            this.cells.put(i, new Cell());
        }

        addJump(new Snake(97, 78));
        addJump(new Snake(95, 56));
        addJump(new Snake(88, 24));
        addJump(new Snake(62, 18));
        addJump(new Snake(48, 26));
        addJump(new Snake(43, 6));

        addJump(new Ladder(2, 38));
        addJump(new Ladder(7, 14));
        addJump(new Ladder(8, 31));
        addJump(new Ladder(15, 26));
        addJump(new Ladder(28, 84));
        addJump(new Ladder(21, 42));
        addJump(new Ladder(36, 44));
        addJump(new Ladder(51, 67));
        addJump(new Ladder(71, 91));
        addJump(new Ladder(78, 98));

    }

    private void addJump(Jump jump) {
        int source = jump.getSource();
        if (cells.containsKey(source)) {
            cells.get(source).assignJump(jump);
        }
    }

    public Integer movePlayer(Player player, Integer rolledNumber){

        int destination = player.getCurrentPosition() + rolledNumber;

        if (destination > 100) {
            System.out.println("Cannot move beyond 100");
            return player.getCurrentPosition();
        }

        Cell destinationCell = cells.get(destination);
        player.setCurrentPosition(destination);

        if (destinationCell.hasJump()) {
            Jump jump = destinationCell.getJump();

            if (jump instanceof Snake) {
                System.out.println(player.getName() + " encountered a Snake!");
            } else if (jump instanceof Ladder) {
                System.out.println(player.getName() + " climbed a Ladder!");
            }

            destination = jump.getDestination();
            player.setCurrentPosition(destination);
        }

        return destination;

    }

}
