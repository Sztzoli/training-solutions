package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {
    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {

        this.maxPassengers = maxPassengers;
    }



    @Override
    public int loadPassenger(int passengers) {
        int leftPassengers = 0;
        if (passengers <= maxPassengers){
            this.passengers = passengers;
            return leftPassengers;
        } else {
            this.passengers = maxPassengers;
            return passengers-maxPassengers;
        }

    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
