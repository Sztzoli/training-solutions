package inheritancemethods.bankaccount;

public class DebitAccount {
    private String accountNumber;
    private long balance;

    public static final double COST = 3.;
    public static final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        return (amount*COST/100d > 200 ) ? (amount*(int)COST)/100 : 200;

    }
    public boolean transaction(long amount) {
        if (amount < balance + costOfTransaction(amount)) {
            balance -= (amount+costOfTransaction(amount));
            return true;
        }
       return false;
    }
    public void balanceToZero() {
        balance=0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
