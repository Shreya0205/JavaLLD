package Code;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Jump jump;

    public void assignJump(Jump jump) {
        this.jump = jump;
    }

    public boolean hasJump() {
        return this.jump != null;
    }

    public Jump getJump() {
        return this.jump;
    }

}
