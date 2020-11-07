package numbers;

public class Circle {
    private int diameter;
    private double PI;

    public Circle(int diameter) {
        this.diameter = diameter;
        PI = (Math.round(Math.PI * 100)) / 100.;
    }

    public double perimeter() {
        return Math.round(diameter * PI*100)/100d;
    }

    public double area() {
        return (double) diameter * diameter / 4 * PI;
    }

}
