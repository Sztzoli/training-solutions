package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {
    private List<Transaction> transactions;

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime, LocalDateTime endTime, int target) {
        int i=0;
        boolean contains=false;
        while (i<transactions.size() && !contains){
            if(transactions.get(i).getDateOfTransaction().isAfter(startTime) && transactions.get(i).getDateOfTransaction().isBefore(endTime)){
                if (transactions.get(i).isDebit() && transactions.get(i).getAmount()>target){
                    contains=true;
                }
            }
            i++;
        }
        return contains;
    }
}
