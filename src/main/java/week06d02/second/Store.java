package week06d02.second;



import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        if (products == null || products.size() == 0) {
            throw new IllegalArgumentException("list can't be null or empty");
        }
        this.products = products;
    }

    public String getProductsByCategory() {
        StringBuilder sb = new StringBuilder();
        for (Category category : Category.values()) {
            sb.append(String.format("%s : %d piece(s)\n", category.name(), category.getPieces()));
        }
        return sb.toString();
    }


}
