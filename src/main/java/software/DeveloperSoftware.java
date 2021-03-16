package software;

public class DeveloperSoftware extends Software{

    public DeveloperSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        price = price * 1.1d;
    }
}
