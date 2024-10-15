

public class Elevator {
    int ElevatorID;
    int FloorID;
    int Capacity;
    InsidePanel insidePanel;
    State state;

    public Elevator(int elevatorID, int capacity, ElevatorController subscriber){
        this.ElevatorID = elevatorID;
        this.FloorID = 0;
        this.Capacity = capacity;
        this.insidePanel = new InsidePanel(elevatorID, subscriber);
        this.state = State.stationary;
    }
}
