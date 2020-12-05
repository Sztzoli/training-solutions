package exceptionclass.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Bank(List<Account> accounts) {
        if (accounts==null){
            throw new IllegalArgumentException();
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount) {
        searchByAccountNumber(accountNumber).subtract(amount);
    }

    public void deposit(String accountNumber, double amount) {
        searchByAccountNumber(accountNumber).deposit(amount);
    }


    private Account searchByAccountNumber(String accountNumber) {
        for (Account account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return account;
            }
        }
        throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
