public interface ElevatorMovementStrategy {
    public void addRequest(Integer floorID, Elevator elevator);
    public void processRequest(Elevator elevator);
}
