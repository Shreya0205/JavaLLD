public enum Coin {
    one(1), two(2), five(5), ten(10);

    private final int code;

    Coin(int i) {
        code=i;
    }

    public static Coin getCoinEnum(Integer coin){
        if(coin==1)
            return Coin.one;
        else if(coin == 2)
            return Coin.two;
        else if(coin == 5)
            return Coin.five;
        else if(coin == 10)
            return Coin.ten;
        return null;
    }

    public int getCode(){
        return code;
    }
}
