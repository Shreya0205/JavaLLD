import GetElevatorStrategy.GetElevatorController;

public class OutsidePanel {
    int OutsidePanelID;
    GetElevatorController getElevatorController;

    public OutsidePanel(GetElevatorController GetElevatorController){
        this.getElevatorController = getElevatorController;
    }

    public void goUp(int floorID){
        this.getElevatorController.goUp(floorID);
    }

    public void goDown(int floorID){
        this.getElevatorController.goDown(floorID);
    }
}
