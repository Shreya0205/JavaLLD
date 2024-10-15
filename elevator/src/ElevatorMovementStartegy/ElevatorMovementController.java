package ElevatorMovementStartegy;

public class ElevatorMovementController {
    public ElevatorMovementStrategy elevatorMovementStrategy;

    public ElevatorMovementController(ElevatorMovementStrategy f){
        this.elevatorMovementStrategy = f;
    }

    public void goToFloor(int floorID, String state) {
        this.elevatorMovementStrategy.goUp(floorID, state);
    }
}
