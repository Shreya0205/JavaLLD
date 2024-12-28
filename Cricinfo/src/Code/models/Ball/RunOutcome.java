package Code.models.Ball;

public class RunOutcome extends BallOutcome {

    Integer runs;

    public RunOutcome(BallOutcomeType type, Integer runs) {
        super(type);
        this.runs = runs;
    }

    public Integer getRuns() {
        return runs;
    }

}
