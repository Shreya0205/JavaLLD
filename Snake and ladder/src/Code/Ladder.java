package Code;

public class Ladder extends Jump {

    public Ladder(int source, int destination) {
        super(source, destination);
        if (source >= destination) {
            throw new IllegalArgumentException("Ladder source must be less than destination.");
        }
    }

}
