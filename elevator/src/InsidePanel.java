public class InsidePanel {
    int InsidePanelID;
    ElevatorController subscriber;

    public InsidePanel(int insidePanelID, ElevatorController subscriber){
        this.InsidePanelID = insidePanelID;
        this.subscriber = subscriber;
    }

    void goToFloor(int floorID){
        this.subscriber.goUp(floorID);
    }
}
