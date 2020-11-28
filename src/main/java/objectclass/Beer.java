package objectclass;

public class Beer {
    private String name;
    private int price;

    public Beer(String name, int price) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("name can't be null or blank");
        }
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("price can't be negative");
        }
        this.price = price;
    }

    private boolean isEmpty(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beer beer = (Beer) o;

        if (price != beer.price) return false;
        return name != null ? name.equals(beer.name) : beer.name == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }
}
