package statement;

public class Investment {
    private double cost=0.3;
    private int fund;
    private int interestRate;
    private boolean active=true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        double yield=fund*interestRate*days/(100.0*365);
        return yield;

    }

    public double close(int days){
        double finalYield = active==true? (getYield(days)+fund)*(1-cost/100.0) : 0 ;
        active = false;
        return finalYield;

    }

}
