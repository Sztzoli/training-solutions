package introinheritance.basket;


import java.util.List;

public class ShoppingBasket {
    private Basket basket = new Basket();


    public void addItem(Item item) {
        if (item==null) {
            throw new IllegalArgumentException("Item is null");
        }
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        if (barcode==null || barcode.isBlank()) {
            throw new IllegalArgumentException("barcode is null");
        }
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        int result = 0;
        for (Item item : basket.getItems()) {
            result += item.getNettoPrice();
        }
        return result;
    }

    public double sumTaxValue() {
        int result = 0;
        for (Item item : basket.getItems()) {
            result += item.getTaxAmount();
        }
        return result;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        basket.removeItem(findItemMostExpensive().getBarcode());
    }

    private Item findItemMostExpensive() {
        List<Item> list = basket.getItems();
        double max = list.get(0).getNettoPrice();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            double price = list.get(i).getNettoPrice();
            if (max < price) {
                max = price;
                index = i;
            }
        }
        return list.get(index);
    }
}
