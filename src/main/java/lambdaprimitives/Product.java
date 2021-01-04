package lambdaprimitives;

public class Product {
    private String name;
    private double price;
    private int numberOfItem;

    public Product(String name, double price, int numberOfItem) {
        this.name = name;
        this.price = price;
        this.numberOfItem = numberOfItem;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }
}
