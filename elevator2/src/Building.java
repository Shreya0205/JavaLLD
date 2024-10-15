import OutsidePanelController.GetOutsidePanelElevator;

import java.util.ArrayList;

public class Building {
    ArrayList<Floor> floors;
    OutsidePanelElevatorController outsidePanelElevatorController;
    ArrayList<Elevator> elevators;

    public Building(int floors, int elevators, int capacity){
        this.floors =  new ArrayList<>();
        this.outsidePanelElevatorController =  new OutsidePanelElevatorController();
        this.elevators = new ArrayList<>();

        for(int i=0;i<=floors;i++){
            this.floors.add(new Floor(i + 1, this.outsidePanelElevatorController));
        }

        for(int i=1;i<=elevators;i++){
            Elevator elevator =  new Elevator(i, capacity);
            this.elevators.add(elevator);
            this.outsidePanelElevatorController.addElevator(elevator);
            Thread elevatorThread = new Thread(elevator::run);
            elevatorThread.start();
        }
    }

    public Floor getFloor(int floorID){
        return this.floors.get(floorID);
    }
}
