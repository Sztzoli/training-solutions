package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

    private List<Door> doors= new ArrayList<>();
    private int numberOfDoors;

    public Sultan(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public List<Double> easy() {
        List<Double> squareNumbers = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(numberOfDoors) ; i++) {
           squareNumbers.add(Math.pow(i, 2));
        }
        return squareNumbers;
    }


    public List<Door> openDoors() {
        init();
        for (int i = 1; i <= numberOfDoors; i++) {
            change(i);
        }
        return opemType();
    }

    private void init() {
        for (int i = 1; i <= numberOfDoors; i++) {
            doors.add(new Door(i));
        }
    }

    private void change(int index){
        for (Door door : doors ) {
            if (door.getNumberOfDoor()%index==0) {
                door.setTypeOfDoor(door.getTypeOfDoor().keyRotate());
            }
        }
    }

    private List<Door> opemType() {
        List<Door> openDoor = new ArrayList<>();
        for (Door door : doors) {
              if (door.getTypeOfDoor().isOpen(door)) {
                  openDoor.add(door);
              }
        }
        return openDoor;
    }


}
