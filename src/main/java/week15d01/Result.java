package week15d01;

public class Result {
    private int maximum = 0;
    private int minimum = 0;
    private int difference = 0;

    public Result() {
    }


    public void valueOf(int maximum, int minimum) {
        if ((maximum - minimum) > difference) {
            this.maximum = maximum;
            this.minimum = minimum;
            this.difference = maximum - minimum;
        }
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getDifference() {
        return difference;
    }

    @Override
    public String toString() {
        return "Result{" +
                "maximum=" + maximum +
                ", minimum=" + minimum +
                '}';
    }
}
