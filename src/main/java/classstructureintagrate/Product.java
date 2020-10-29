package classstructureintagrate;

public class Product {
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void increasePrice(int value) {
        price += value;
    }
    public void decreasePrice(int value) {
        price -= value;
    }

   public String printOut() {
        return name + " " + price;
   }
}
