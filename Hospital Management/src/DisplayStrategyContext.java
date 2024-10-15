import java.util.ArrayList;

public class DisplayStrategyContext {
    DisplayStrategy displayStrategy;

    public DisplayStrategyContext(DisplayStrategy displayStrategy){
        this.displayStrategy = displayStrategy;
    }

    public void displaySlots(ArrayList<Doctor> doctors){
        this.displayStrategy.displaySlots(doctors);
    }
}
