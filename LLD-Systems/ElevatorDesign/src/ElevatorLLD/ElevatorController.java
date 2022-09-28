package ElevatorLLD;


import java.util.PriorityQueue;

public  class ElevatorController {

    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);

    }
     public void submitExternalRequest(int floor, Direction direction,int destinationFloor){

        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
        submitInternalRequest(destinationFloor);
        if(elevatorCar.currentFloor==0)
        {
        	moveElevator(Direction.UP,destinationFloor);
        }
        else
        	moveElevator(direction,destinationFloor);
     }

    public void submitInternalRequest(int floor){
    	int currentFloor=elevatorCar.currentFloor;
    	if(floor>currentFloor)
    		upMinPQ.offer(floor);
    	else 
    		downMaxPQ.offer(floor);
    }
    public void showDisplay() {
        elevatorCar.display.showDisplay();
   }

   public void pressButton(int destination) {
       elevatorCar.internalButtons.pressButton(destination, this);
   }

   public void setDisplay() {
	   elevatorCar.display.setDisplay(elevatorCar.currentFloor, elevatorCar.elevatorState);
   }

   boolean moveElevator(Direction dir, int destinationFloor){
       int startFloor = elevatorCar.currentFloor;
       if(dir == Direction.UP) {
    	   elevatorCar.elevatorState=ElevatorState.UP;
           for(int i = startFloor; i<=destinationFloor; i++) {

        	   elevatorCar.currentFloor = i;
               setDisplay();
               showDisplay();
               if(i == destinationFloor) {
                   return true;
               }
           }
       }

       if(dir == Direction.DOWN) {
    	   elevatorCar.elevatorState=ElevatorState.DOWN;
           for(int i = startFloor; i>=destinationFloor; i--) {

        	   elevatorCar.currentFloor = i;
               setDisplay();
               showDisplay();
               if(i == destinationFloor) {
                   return true;
               }
           }
       }
       return false;
   }

   
}
