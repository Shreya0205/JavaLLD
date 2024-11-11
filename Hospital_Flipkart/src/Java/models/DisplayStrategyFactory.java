package Java.models;

public class DisplayStrategyFactory {

    public static DisplayStrategy getDisplayStartegy(DisplayStrategyEnum displayStrategyEnum){

        if(displayStrategyEnum == DisplayStrategyEnum.ranking)
            return RankingDisplayStartegy.getInstance();
        return RankingDisplayStartegy.getInstance();

    }
}
