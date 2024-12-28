package Code.models.Ball;

import Code.models.Player;

public class Ball {

    Integer id;
    Player baller;
    Player batter;
    BallOutcome ballOutcome;

    public Ball(Integer id, Player baller, Player batter, BallOutcome ballOutcome) {
        this.id = id;
        this.baller = baller;
        this.batter = batter;
        this.ballOutcome = ballOutcome;
    }

    public Integer getId() {
        return id;
    }

    public Player getBaller() {
        return baller;
    }

    public Player getBatter() {
        return batter;
    }

    public BallOutcome getBallOutcome() {
        return ballOutcome;
    }
}
