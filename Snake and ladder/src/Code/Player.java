package Code;

public class Player {

    private final String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 1;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

}
