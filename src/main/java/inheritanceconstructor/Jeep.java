package inheritanceconstructor;

public class Jeep extends Car{
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        if (extraFuel>fuel){
            extraFuel+=fuel;
        } else if (extraFuel!=0) {
            super.modifyFuelAmount(-(fuel-extraFuel));
            extraFuel=0;
        } else {
            super.modifyFuelAmount(fuel);
        }

    }

    @Override
    public void drive(int km) {
        if (!enoughFuel(km)) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        modifyFuelAmount(Math.abs(fuelPerRkm)*km);




    }

    @Override
    public double calculateRefillAmount() {
        return super.calculateRefillAmount()+extraCapacity-extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    @Override
    protected boolean enoughFuel(int km) {
        if(getFuel() + extraFuel < Math.abs(fuelPerRkm*km)) {
            return false;
        }
        return true;
    }


}
