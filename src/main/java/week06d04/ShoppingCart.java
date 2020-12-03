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
        Item charItem = getItemByName(name);
        if (charItem==null){
            shoppingList.add(new Item(name, quantity));
        } else {
            charItem.increaseQuantity(quantity);
        }

    }

    private Item getItemByName(String name) {
        for (Item item : shoppingList) {
            if (name.equals(item.getName())) {
                return item;
            }

        }
        return null;

    }

    public int getItem (String name) {
        if (getItemByName(name)==null) {
            return 0;
        }
        return getItemByName(name).getQuantity();
    }

    public List<Item> getShoppingList() {
        return List.copyOf(shoppingList);
    }

    @Override
    public String toString() {
        return  shoppingList.toString();
    }
}