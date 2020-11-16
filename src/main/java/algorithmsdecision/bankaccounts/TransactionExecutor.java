package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction transaction : transactions ) {
            boolean find=false;
            int i=0;
            while (i<accounts.size() && !find){
                if(transaction.getAccountNumber().equals(accounts.get(i).getAccountNumber())){
                    if (transaction.isCredit()){
                        accounts.get(i).deposit(transaction.getAmount());
                        transaction.setStatus(TransactionStatus.SUCCEEDED);
                    } else if (transaction.isDebit()){
                        accounts.get(i).withdraw(transaction.getAmount());
                        transaction.setStatus(TransactionStatus.SUCCEEDED);
                    } else {
                        transaction.setStatus(TransactionStatus.PENDING);
                    }
                    find=true;
                }
                i++;
            }
        }
    }
}
