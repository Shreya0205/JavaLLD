public class Elevator {
    Integer ElevatorID;
    Integer capacity;
    Integer currentFloor;
    Direction direction;
    InsidePanel insidePanel;
    ElevatorMovementStrategy elevatorMovementStrategy;
    public Integer requests;

    public Elevator(int elevatorID, int capacity){
        this.ElevatorID = elevatorID;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.direction = Direction.Up;
        this.insidePanel = new InsidePanel();
        this.elevatorMovementStrategy = new NearestMovementStrategy();
        this.requests = 0;
    }

    public Integer getCurrentFloor(){
        return currentFloor;

    }

    public Direction getDirection(){
        return direction;
    }

    public void setCurrentFloor(Integer floorID){
        currentFloor = floorID;
        System.out.println("Elevator " + this.ElevatorID + " reached floor: " + this.getCurrentFloor());
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public synchronized void addRequest(Integer floorID){
        requests = requests + 1;
        System.out.println("Adding request for Elevator " + this.ElevatorID + " for floor: " + floorID);
        this.elevatorMovementStrategy.addRequest(floorID, this);
        notify();
    }

    public synchronized void processRequests(){
        while (true) {  // Continuous processing
            while (requests == 0) {  // Check if there are no requests
                try {
                    wait();  // Wait while holding the lock if no requests
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Process the request if requests are available
            elevatorMovementStrategy.processRequest(this);
            requests--;
        }
    }

    public void run(){
        processRequests();
    }
}
