package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item==null) {
            throw new IllegalArgumentException("Item is null");
        }
        items.add(item);
    }
    public void removeItem(String barcode) {
        if (barcode==null || barcode.isBlank()) {
            throw new IllegalArgumentException("barcode is null");
        }
        items.remove(findItemByBarcode(barcode));
    }
    public void clearBasket() {
        items.clear();
    }
    public List<Item> getItems() {
        return List.copyOf(items);
    }

    private Item findItemByBarcode(String barcode){
        for (Item item : items) {
            if(barcode.equals(item.getBarcode())){
                return item;
            }
        }
        throw new IllegalArgumentException("barcode is wrong");
    }
}
