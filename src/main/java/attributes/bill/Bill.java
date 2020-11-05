package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items=new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public double calculateTotalPrice(){
        double sum=0;
        for (Item item:items
             ) {
            sum+=(item.getPrice()*item.getQuantity());
        }
        return sum;
    }
}
