import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class NearestMovementStrategy implements ElevatorMovementStrategy {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxHeap;

    public NearestMovementStrategy(){
        this.minheap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addRequest(Integer floorID, Elevator elevator){
        if(elevator.getCurrentFloor() > floorID){
            maxHeap.add(floorID);
        }
        else{
            minheap.add(floorID);
        }
    }

    public void processRequest(Elevator elevator) {
        if(minheap.isEmpty() && minheap.isEmpty())
            return;

        if (elevator.getDirection() == Direction.Up){
            elevator.setCurrentFloor(minheap.remove());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (minheap.isEmpty()){
                elevator.setDirection(Direction.Down);
            }
        }
        else{
            elevator.setCurrentFloor(maxHeap.remove());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (maxHeap.isEmpty()){
                elevator.setDirection(Direction.Up);
            }
        }


    }
}
