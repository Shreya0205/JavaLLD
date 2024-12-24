package Code;

public enum Coin {

    ONE(1),
    TWO(2),
    ten(10),
    fifty(50),
    hundred(100);

    public final int value;

    Coin(int value){
        this.value = value;
    }

}
