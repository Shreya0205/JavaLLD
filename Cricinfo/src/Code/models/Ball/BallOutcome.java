package Code.models.Ball;

public abstract class BallOutcome {
    BallOutcomeType type;

    public BallOutcome(BallOutcomeType type) {
        this.type = type;
    }

    public BallOutcomeType getType() {
        return type;
    }
}
