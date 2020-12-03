package week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> shoppingList = new ArrayList<>();

    public void addItem(String name, int quantity) {
        if (name==null|| name.isBlank()) {
        throw new IllegalArgumentException("name can't be null or blank");
        }
        if (quantity<0) {
            throw new IllegalArgumentException("quantity can't be negative ");
        }
        if (!isContain(name, quantity)) {
            shoppingList.add(new Item(name, quantity));
        }

    }

    private boolean isContain(String name, int quantity) {
        for (Item item : shoppingList) {
            if (name.equals(item.getName())) {
                item.increaseQuantity(quantity);
                return true;
            }

        }
        return false;

    }

    public List<Item> getShoppingList() {
        return List.copyOf(shoppingList);
    }

    @Override
    public String toString() {
        return  shoppingList.toString();
    }
}