package software;

public class OfficeSoftware extends Software{

    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        price = price * 1.05d;
    }
}
