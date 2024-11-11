package Java.models;

import java.util.ArrayList;
import java.util.Collection;

public class RankingDisplayStartegy implements DisplayStrategy{

    private static RankingDisplayStartegy rankingDisplayStartegy;

    private RankingDisplayStartegy(){}

    public static RankingDisplayStartegy getInstance(){
        if(rankingDisplayStartegy == null){
            rankingDisplayStartegy = new RankingDisplayStartegy();
        }
        return rankingDisplayStartegy;
    }

    public void displaySlots(ArrayList<Slot> slots){
        for(Slot slot: slots){
            System.out.println(slot.toString());
        }
    }
}
