package finalmodifier;

public class CylinderCalculatorBasedOnCircle {
    public double calculateVolume(double r, double h){
        return new CircleCalculator().calculateArea(r)*h;
    }
    public double calculateSurfaceArea(double r, double h){
        return new CircleCalculator().calculateArea(r)*2+new CircleCalculator().calculatePerimeter(r)*h;
    }
}
