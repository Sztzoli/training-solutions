package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    public static final String REGEX = ";";
    private List<BankAccount> accountList = new ArrayList<>();


    public void uploadListFromFile(String relativePath) {
        initAccounts(uploadStringListFromFile(relativePath));
    }

    private void initAccounts (List<String> lines) {
        for (String account : lines ) {
            String[] parts = account.split(REGEX);
            accountList.add(new BankAccount(parts[0], parts[1], Integer.parseInt(parts[2]) ));
        }
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    private List<String> uploadStringListFromFile(String relativePath){
        Path myFile = Path.of(relativePath);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(myFile);
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
        return lines;
    }

    public void makeTransactions(String relativePath) {
        List<String> transactions = uploadStringListFromFile(relativePath);
        for (String transaction : transactions) {
            String[] parts = transaction.split(REGEX);
            BankAccount account = searchByAccountNumber(parts[0]);
            account.setBalance(Double.parseDouble(parts[1]));
        }

    }

    private BankAccount searchByAccountNumber(String accountNumber) {
        for (BankAccount account : accountList) {
            if ( accountNumber.equals(account.getAccountNumber())) {
                return account;
            }
        }
        return null;
    }
}
