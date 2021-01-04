package week10d01;

public class Result {
    private double rise;
    private double decrease;

    public Result(double rise, double decrease) {
        this.rise = rise;
        this.decrease = decrease;
    }

    public double getRise() {
        return rise;
    }

    public double getDecrease() {
        return decrease;
    }

    public void addRise(double number) {
        this.rise += number;
    }

    public void addDec(double number) {
        this.decrease += number;
    }
}
