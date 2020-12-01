package week06d02;

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
            sb.append(String.format("%s : %d piece(s)\n", category.name(), Count(category)));
        }
        return sb.toString();
    }

    private int Count(Category category) {
        int count = 0;
        for (Product product : products) {
            if (product==null){
                throw new IllegalArgumentException("product can't be null");
            }
            if (category == product.getCategory()) {
                count++;
            }
        }
        return count;
    }
}
