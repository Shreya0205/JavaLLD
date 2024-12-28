package Code.models;

import Code.models.Ball.Ball;

import java.util.ArrayList;
import java.util.List;

public class Over {
    Integer overNumber;
    List<Ball> balls;

    public Over(Integer id) {
        this.overNumber = id;
        this.balls = new ArrayList<>();
    }

    public void addBall(Ball ball){
        this.balls.add(ball);
    }

    public Integer getOverNumber() {
        return overNumber;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
