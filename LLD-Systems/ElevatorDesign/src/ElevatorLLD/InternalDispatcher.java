package ElevatorLLD;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, ElevatorController elevatorController){
    	elevatorController.submitInternalRequest(floor);
    }
}
