package introinheritance.basket;

public class Item {
    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        if (barcode==null || barcode.isBlank()) {
            throw new IllegalArgumentException("barcode is null");
        }
        this.barcode = barcode;
        if (nettoPrice<0){
            throw new IllegalArgumentException("nettoprice is negativ");
        }
        this.nettoPrice = nettoPrice;
        if (vatPercent<0 || vatPercent>100){
            throw new IllegalArgumentException("vapercent is wrong");
        }
        this.vatPercent = vatPercent;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public double getTaxAmount() {
        return nettoPrice*vatPercent/100d;
    }

    @Override
    public String toString() {
        return "Item{" + "barcode='" + barcode + '\'' +", nettoPrice=" + nettoPrice +  ", vatPercent=" + vatPercent + '}';
    }
}
