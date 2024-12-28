package Code.models.Ball;

import Code.models.Player;

public class OutOutcome extends BallOutcome {

    Player byPlayer;
    OutType outType;

    public OutOutcome(BallOutcomeType type, Player byPlayer, OutType outType) {
        super(type);
        this.byPlayer = byPlayer;
        this.outType = outType;
    }

    public Player getByPlayer() {
        return byPlayer;
    }

    public OutType getOutType() {
        return outType;
    }
}
