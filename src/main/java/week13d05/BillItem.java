package week13d05;

public class BillItem {
    private final String name;
    private final int number;
    private final int unitPrice;

    public BillItem(String name, int number, int unitPrice) {
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%d %s, darabja %d Ft",getNumber(),getName(),getUnitPrice());
    }
}
