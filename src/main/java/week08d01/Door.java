package week08d01;

public class Door {
    private DoorType typeOfDoor = DoorType.CLOSED;
    private int numberOfDoor;

    public DoorType getTypeOfDoor() {
        return typeOfDoor;
    }

    public Door(int numberOfDoor) {
        this.numberOfDoor = numberOfDoor;
    }

    public int getNumberOfDoor() {
        return numberOfDoor;
    }

    public void setTypeOfDoor(DoorType typeOfDoor) {
        this.typeOfDoor = typeOfDoor;
    }

    @Override
    public String toString() {
        return String.format("%d door is open", numberOfDoor);
    }
}
