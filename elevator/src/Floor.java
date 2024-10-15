import GetElevatorStrategy.GetElevatorController;

public class Floor {
    int FloorID;
    OutsidePanel outsidePanel;

    public Floor(int floorID, GetElevatorController getElevatorController){
        this.FloorID =  floorID;
        this.outsidePanel = new OutsidePanel(getElevatorController);
    }
}
