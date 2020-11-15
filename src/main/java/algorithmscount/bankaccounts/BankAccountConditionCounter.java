package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int i) {
        int count=0;
        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getBalance()>i) {
                count++;
            }

        }
        return count;
    }
}
