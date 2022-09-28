package ElevatorLLD;

public class ElevatorDisplay {

    int floor;
    ElevatorState elevatorState;

    public void setDisplay(int floor, ElevatorState elevatorState) {
        this.floor = floor;
        this.elevatorState = elevatorState;
    }

    public void showDisplay(){
        System.out.println("Reached Floor--> "+floor);
        System.out.println("Moving in "+elevatorState+" direction");
    }
}
