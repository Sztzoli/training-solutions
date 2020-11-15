package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {
    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        int min=salespersons.get(0).getDifferenceFromTarget();
        Salesperson salesperson=salespersons.get(0);
        for (int i = 1; i < salespersons.size(); i++) {
            if(min>salespersons.get(i).getDifferenceFromTarget()){
                min=salespersons.get(i).getDifferenceFromTarget();
                salesperson=salespersons.get(i);
            }
        }
        return salesperson;
    }
}
