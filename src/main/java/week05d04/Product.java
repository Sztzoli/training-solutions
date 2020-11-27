package week05d04;

public class Product {
    private final long price;
    private final Currency currency;

    public Product(long price, String currency) {
        if (price < 0) {
            throw new IllegalArgumentException("price is wrong");
        }
        this.price = price;
        if (currency==null){
            throw new IllegalArgumentException("Currency is wrong");
        }
        try {
            this.currency=Currency.valueOf(currency.toUpperCase());

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Currency is wrong");
        }

    }



    public long getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double convertPrice(Currency currency){
        double result = price * this.currency.getExchangeRate() / currency.getExchangeRate();
        return result;
    }
}
