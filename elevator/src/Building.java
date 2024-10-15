import ElevatorMovementStartegy.ElevatorMovementStrategy;
import GetElevatorStrategy.GetElevatorStrategy;

import java.util.ArrayList;

public class Building {
    int BuildingID;
    ArrayList<Floor> floors;

    public Building(int buildingID, int floors){
        this.BuildingID = buildingID;
        this.floors =  new ArrayList<Floor>(floors);
        for(int i=0;i<floors;i++){
            this.floors.set(i, new Floor(i + 1));
        }
    }

    Elevator addElevator(int elevatorID, int capacity, GetElevatorStrategy getElevatorStrategy,
                                   ElevatorMovementStrategy elevatorMovementStrategy){

        ElevatorController elevatorController = new ElevatorController(
                getElevatorStrategy,
                elevatorMovementStrategy);

        Elevator elevator = new Elevator(elevatorID, capacity, elevatorController);
        return elevator;
    }
}
