package classstructureconstructors;

public class Store {
    private String product;
    private int stick;

    public String getProduct() {
        return product;
    }

    public int getStick() {
        return stick;
    }

    public Store(String product) {
        this.product = product;

    }

    public void store (int value) {
        stick = stick + value;
    }

    public void dispatch (int value) {
        stick= stick - value;
    }
}
