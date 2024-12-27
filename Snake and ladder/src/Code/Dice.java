package Code;

import java.util.Random;

public class Dice {

    Integer limit;

    public Dice(Integer limit) {
        this.limit = limit;
    }

    public Integer rollDice(){
        Random random = new Random();
        return random.nextInt(limit) + 1;
    }

}
