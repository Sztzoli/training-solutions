package week06d02;


public class Product {

    private final String name;
    private final Category category;
    private final int price;

    public Product(String name, Category category, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name can't be null or blank");
        }
        this.name = name;
        this.category = category;
        if (price < 0) {
            throw new IllegalArgumentException("price can't be negative");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("name: %s\ncategory: %s\nprice: %d", name, category.name(), price);
    }
}
