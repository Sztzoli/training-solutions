package virtualmethod.vehicle;

public class Van extends Car {

    private int cargoWeight;

    public Van(int vehicleWeight, int numberPassenger, int cargoWeight) {
        super(vehicleWeight, numberPassenger);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeight;
    }

    @Override
    public String toString() {
        return String.format("Van{cargoWeight=%d, %s}", cargoWeight, super.toString().substring(super.toString().indexOf("{")+1,super.toString().lastIndexOf("}")));
    }
}
