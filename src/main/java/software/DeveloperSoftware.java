package software;

public class DeveloperSoftware extends Software{

    public DeveloperSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        super.setPrice(super.getPrice()*1.1d);
    }
}
