import ElevatorMovementStartegy.ElevatorMovementController;
import ElevatorMovementStartegy.ElevatorMovementStrategy;
import GetElevatorStrategy.GetElevatorController;
import GetElevatorStrategy.GetElevatorStrategy;

public class ElevatorController {
    Elevator elevator;
    GetElevatorController getElevatorController;
    ElevatorMovementController elevatorMovementController;

    public ElevatorController(GetElevatorStrategy getElevatorStrategy,
                              ElevatorMovementStrategy elevatorMovementStrategy){
        this.getElevatorController = new GetElevatorController(getElevatorStrategy);
        this.elevatorMovementController = new ElevatorMovementController(elevatorMovementStrategy);

    }

    void goUp(int floorID){
        this.getElevatorController.goUp(floorID);
    }

    void goDown(int floorID){
        this.getElevatorController.goDown(floorID);
    }

    void goToFloor(int floorID){
        this.elevatorMovementController.goToFloor(floorID, String.valueOf(this.elevator.state));
    }


}
