package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;


    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int numberOfPerson, int cargoWeight) {
        int leftPerson = numberOfPerson;
        int leftWeight = cargoWeight;
        for (Ship ship : ships) {
            if (ship instanceof CanCarryGoods) {
                if (leftWeight != 0){
                    leftWeight = ((CanCarryGoods) ship).loadCargo(leftWeight);
                }
            }
            if (ship instanceof CanCarryPassengers) {
                if (leftPerson !=0) {
                   leftPerson = ((CanCarryPassengers) ship).loadPassenger(leftPerson);
                }

            }
        }
        waitingPersons = leftPerson;
        waitingCargo = leftWeight;
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
