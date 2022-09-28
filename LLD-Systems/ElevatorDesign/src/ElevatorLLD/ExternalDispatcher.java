package ElevatorLLD;

import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction,int destination){


        //for simplicity, i am following even odd,
//        for(ElevatorController elevatorController : elevatorControllerList) {
//
//           int elevatorID = elevatorController.elevatorCar.id;
//           if (elevatorID%2==1 && floor%2==1){
//               elevatorController.submitExternalRequest(floor,direction);
//           } else if(elevatorID%2==0 && floor%2==0){
//               elevatorController.submitExternalRequest(floor,direction);
//
//           }
//        }
    	
    	//looking for nearest elevator car
    	ElevatorController nearestElevator=null;
    	ElevatorState dir=ElevatorState.IDLE;
    	if(direction==Direction.UP)
    		dir=ElevatorState.UP;
    	else 
    		dir=ElevatorState.DOWN;
    	int minimumDistance=Integer.MAX_VALUE;
    	for(ElevatorController elevatorController : elevatorControllerList) {
    		int currentFloor=elevatorController.elevatorCar.currentFloor;
    		//case1: when elevator is going up and user also wants to go up
    		//case2: when elevator is going down and user also wants to go down
    		//case3: when elevator is going down and user wants to go up
    		//case4: when elevator is going up and user wants to go down
    		if(Math.abs(floor-currentFloor)<minimumDistance)
    		{
    			nearestElevator=elevatorController;
    			minimumDistance=Math.abs(floor-currentFloor);
    		}
    	}
    	nearestElevator.submitExternalRequest(floor, direction,destination);
    }

}
