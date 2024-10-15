import OutsidePanelController.GetOutsidePanelElevator;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class OutsidePanelElevatorController {
    ArrayList<Elevator> elevators;

    public OutsidePanelElevatorController(){
        this.elevators = new ArrayList<Elevator>();
    }

    public void addElevator(Elevator elevator){
        this.elevators.add(elevator);
    }

    public void addRequest(Integer floorID){
        Integer Distance = Integer.MAX_VALUE;
        Elevator elevator = null;

        for(int i=0;i<this.elevators.size();i++){
            Integer dist = abs(floorID - this.elevators.get(i).getCurrentFloor());
            if( Distance >  dist ){
                Distance = dist;
                elevator = this.elevators.get(i);
            }
        }
        elevator.addRequest(floorID);
    }

    
}
