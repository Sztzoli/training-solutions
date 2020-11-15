package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        int max=salespersons.get(0).getDifferenceFromTarget();
        Salesperson salesperson=salespersons.get(0);
        for (int i = 1; i < salespersons.size(); i++) {
            if(max<salespersons.get(i).getDifferenceFromTarget()){
                max=salespersons.get(i).getDifferenceFromTarget();
                salesperson=salespersons.get(i);
            }
        }
        return salesperson;
    }
}
