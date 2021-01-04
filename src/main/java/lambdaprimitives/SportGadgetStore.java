package lambdaprimitives;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {

    private List<Product> products = new ArrayList<>();

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }


    public long getNumberOfProducts() {
        return products.stream()
                .mapToInt(Product::getNumberOfItem)
                .summaryStatistics()
                .getSum();
    }

    public double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .summaryStatistics()
                .getAverage();
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics statistics = products.stream()
                .filter(product -> product.getPrice()>minPrice)
                .mapToInt(Product::getNumberOfItem)
                .summaryStatistics();

        if (statistics.getCount()==0){
            return "Nincs ilyen termék.";
        }
        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",statistics.getCount(), statistics.getMin(),statistics.getMax(),statistics.getSum());
    }
}
