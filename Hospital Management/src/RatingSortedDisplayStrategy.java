import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RatingSortedDisplayStrategy implements DisplayStrategy{


    public void displaySlots(ArrayList<Doctor> doctors){

        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return Integer.compare(o1.rating, o2.rating);
            }
        });

        Collections.reverse(doctors);

        for (int i = 0; i<doctors.size(); i++){
            if(doctors.get(i).areSlotsAvailable()) {
                doctors.get(i).displaySlots();
            }
        }

    }
}
