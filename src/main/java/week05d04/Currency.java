package week05d04;

public enum Currency {
    HUF(1),
    USD(1/300d);

    private  double exchangeRateToHUF;

    Currency(double exchangeRateToHUF) {
        this.exchangeRateToHUF = exchangeRateToHUF;
    }

    public double getExchangeRateToHUF() {
        return exchangeRateToHUF;
    }
}
