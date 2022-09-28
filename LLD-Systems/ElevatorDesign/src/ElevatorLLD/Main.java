package ElevatorLLD;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1,3);
        
        Floor floor2 = new Floor(4,2);
        Floor floor3 = new Floor(3,1);
        Floor floor4 = new Floor(4,5);
        Floor floor5 = new Floor(5,2);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);

        Building building = new Building(floorList);
//        List<ElevatorController> elevatorControllers=ElevatorCreator.elevatorControllerList;
        floor1.pressButton(Direction.UP);
        floor2.pressButton(Direction.DOWN);
        floor4.pressButton(Direction.UP);
    }
}
