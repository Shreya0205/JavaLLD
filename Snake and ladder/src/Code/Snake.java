package Code;

public class Snake extends Jump {

    public Snake(int source, int destination) {
        super(source, destination);
        if (source <= destination) {
            throw new IllegalArgumentException("Snake source must be greater than destination.");
        }
    }

}
