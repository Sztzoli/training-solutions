package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }


    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparingDouble(BankAccount::getBalance));
        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
        return sorted;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        sorted.sort(Comparator.comparing(BankAccount::getNameOfOwner,
                Comparator.nullsFirst(collator)).
                thenComparing(BankAccount::getAccountNumber));
        return sorted;
    }
}
