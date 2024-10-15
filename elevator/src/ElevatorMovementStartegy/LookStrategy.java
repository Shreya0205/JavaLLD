package ElevatorMovementStartegy;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class LookStrategy implements ElevatorMovementStrategy{
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public LookStrategy(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap =  new PriorityQueue<Integer>(
                Collections.reverseOrder());
    }

    public void goToFloor(int floorID, String state){
        if (Objects.equals(state, "up")){

        }

    }
}
