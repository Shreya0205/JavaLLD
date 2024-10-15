//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Building building =  new Building(15, 3, 10);

        Floor floor1 = building.getFloor(1);
        Floor floor2 = building.getFloor(2);
        Floor floor14 = building.getFloor(14);
        Floor floor13 = building.getFloor(13);
        Floor floor5 = building.getFloor(5);

        floor1.getElevator();
        floor2.getElevator();
        floor14.getElevator();
        floor13.getElevator();
        floor5.getElevator();

    }
}