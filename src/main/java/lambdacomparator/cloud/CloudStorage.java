package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {
    public static final int STANDARD_PERIOD= 12;
    private static final int STANDARD_SIZE = 1000;
    private String provider;
    private int space;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this.provider = provider;
        this.space = space;
        this.period = payPeriod;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    @Override
    public int compareTo(CloudStorage o){
        double currentValue = this.period != null ? this.price * STANDARD_PERIOD / this.period.getLength() / this.space * STANDARD_SIZE : 0;
        double otherValue = o.period != null ? o.price * STANDARD_PERIOD / o.period.getLength() / o.space * STANDARD_SIZE : 0;
        return Double.compare(currentValue, otherValue);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }
}
