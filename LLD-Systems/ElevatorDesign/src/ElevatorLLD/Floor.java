package ElevatorLLD;

public class Floor {
    int floorNumber;
    int destinationFloor;
    ExternalDispatcher externalDispatcher;


    public Floor(int floorNumber,int destinationFloor){
        this.floorNumber = floorNumber;
        this.destinationFloor=destinationFloor;
        externalDispatcher = new ExternalDispatcher();
    }
    public void pressButton(Direction direction) {

        externalDispatcher.submitExternalRequest(floorNumber, direction,destinationFloor);
    }
}
