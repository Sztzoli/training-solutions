package exam03;

public enum CruiseClass {
    LUXURY(3.0),
    FIRST(1.8),
    SECOND(1.0);

    private double luxuryPrice;

    CruiseClass(double luxuryPrice) {
        this.luxuryPrice = luxuryPrice;
    }

    public double getLuxuryPrice() {
        return luxuryPrice;
    }
}
