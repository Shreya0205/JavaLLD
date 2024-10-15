public class Floor {
    Integer FloorID;
    OutsidePanel outsidePanel;

    public Floor(int floorID, OutsidePanelElevatorController outsidePanelElevatorController){
        this.FloorID = floorID;
        this.outsidePanel = new OutsidePanel(outsidePanelElevatorController);
    }

    public void getElevator(){
        this.outsidePanel.getElevator(FloorID);
    }

}
