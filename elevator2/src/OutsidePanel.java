public class OutsidePanel {
    OutsidePanelElevatorController outsidePanelElevatorController;

    public OutsidePanel(OutsidePanelElevatorController outsidePanelElevatorController){
        this.outsidePanelElevatorController = outsidePanelElevatorController;
    }

    void getElevator(Integer floorID){
        this.outsidePanelElevatorController.addRequest(floorID);
    }
}
