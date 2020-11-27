package week05d04;

public enum  Currency {
    HUF(1),
    USD(300);

    private  double exchangeRate;

    Currency(double exchangeRateToHUF) {
        this.exchangeRate = exchangeRateToHUF;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}
