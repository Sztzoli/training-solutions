package finalmodifier;

public class TaxCalculator {
    public final static double VAT = 27.;

    public double tax(double price) {
        return price * VAT / 100;
    }

    public double priceWithTax(double price) {
        return price + tax(price);
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println(taxCalculator.tax(100));
        System.out.println(taxCalculator.priceWithTax(100));
    }
}
