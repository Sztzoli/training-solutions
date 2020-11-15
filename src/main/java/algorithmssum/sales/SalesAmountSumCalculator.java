package algorithmssum.sales;


import java.util.List;

public class SalesAmountSumCalculator {



    public int sumSalesAmount(List<Salesperson> list) {
        int sum = 0;
        for (Salesperson salesperson : list) {
            sum += salesperson.getAmount();
        }
        return sum;
    }
}
