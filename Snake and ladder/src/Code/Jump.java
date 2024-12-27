package Code;

public abstract class Jump {

    Integer source;
    Integer destination;

    public Jump(Integer source, Integer destination) {
        this.source = source;
        this.destination = destination;
    }

    public Integer getSource() {
        return source;
    }

    public Integer getDestination() {
        return destination;
    }

}
