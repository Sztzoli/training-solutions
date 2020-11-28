package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {
    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long realLimit=getBalance()+costOfTransaction(amount);
        if (amount > realLimit + overdraftLimit) {
            return false;
        }
        if (amount > realLimit) {
            overdraftLimit -= ((amount - getBalance()) + costOfTransaction(amount));
            balanceToZero();
            return true;
        }
        super.transaction(amount);
        return true;

    }
}
