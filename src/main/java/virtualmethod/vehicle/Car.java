package virtualmethod.vehicle;

public class Car extends Vehicle{

    private int numberPassenger;

    public Car(int vehicleWeight, int numberPassenger) {
        super(vehicleWeight);
        this.numberPassenger = numberPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad()+numberPassenger* PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return String.format("Car{numberOfPassenger=%d, %s}",numberPassenger, super.toString().substring(super.toString().indexOf("{")+1,super.toString().lastIndexOf("}")));
    }
}
