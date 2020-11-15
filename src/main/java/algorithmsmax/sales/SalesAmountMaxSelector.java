package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {
    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        int max=salespersons.get(0).getAmount();
        Salesperson salesperson=salespersons.get(0);
        for (int i = 1; i < salespersons.size(); i++) {
            if(max<salespersons.get(i).getAmount()){
                max=salespersons.get(i).getAmount();
                salesperson=salespersons.get(i);
            }
        }
        return salesperson;
    }
}
