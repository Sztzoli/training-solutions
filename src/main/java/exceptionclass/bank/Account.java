package exceptionclass.bank;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        objectIsNull(accountNumber);
        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubtract = 100_000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        checkedAmount(maxSubtract);
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) {
        checkedAmount(amount);
        if (balance < amount){
            throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
        }

        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        checkedAmount(amount);
        balance += amount;
        return balance;
    }

    private void checkedAmount(double amount) {
        if (amount<=0) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
    }

    private void objectIsNull(Object ob){
        if (ob==null) {
            throw new IllegalArgumentException();
        }
    }


}
