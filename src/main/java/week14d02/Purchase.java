package week14d02;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private String id;
    private List<Item> items;

    public Purchase(String id, List<Item> items) {
        this.id = id;
        this.items = new ArrayList<>(items);
    }

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }


    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", items=" + items +
                '}';
    }
}
