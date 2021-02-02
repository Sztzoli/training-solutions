package week14d02;




public class Item {

    private String name;
    private int price;

    public Item(String line) {

        this.name = line.substring(0, line.indexOf("("));
        line = line.substring(line.indexOf("(") + 1);
        String price = line.substring(0,line.indexOf(")"));
        this.price = Integer.parseInt(price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
