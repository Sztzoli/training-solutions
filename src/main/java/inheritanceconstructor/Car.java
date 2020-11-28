package inheritanceconstructor;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;
    public static double fuelPerRkm;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        this.fuelRate = fuelRate;
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
        fuelPerRkm =-fuelRate/100d;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel+=fuel;
    }

    public void drive(int km) {
        if (!enoughFuel(km)) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        modifyFuelAmount( fuelPerRkm *km);
    }

    protected boolean enoughFuel(int km) {
        if (fuel < Math.abs(fuelPerRkm *km)) {
            return false;
        }
        return true;
    }

    public double calculateRefillAmount()  {
        return tankCapacity-fuel;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }


}
