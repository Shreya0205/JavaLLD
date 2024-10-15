package GetElevatorStrategy;

public class GetElevatorController {
    GetElevatorStrategy getElevatorStrategy;

    public GetElevatorController(GetElevatorStrategy f){
        getElevatorStrategy = f;
    }

    public void goUp(int floorID){
        this.getElevatorStrategy.goUp(floorID);
    }

    public void goDown(int floorID){
        this.getElevatorStrategy.goDown(floorID);
    }
}
