package week06d02.second;

import org.junit.jupiter.api.Test;
import week06d02.Category;
import week06d02.Product;
import week06d02.Store;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void testStore() {


        List<Product> products = Arrays.asList(new Product("temék1", Category.BAKEDGOODS, 1200),
                new Product("temék2", Category.BAKEDGOODS, 1400),
                new Product("temék3", Category.DAIRY, 1250),
                new Product("temék4", Category.BAKEDGOODS, 1300));
        Store store = new Store(products);
        String excepted = "FROZEN : 0 piece(s)\n" +
                "DAIRY : 1 piece(s)\n" +
                "BAKEDGOODS : 3 piece(s)\n" +
                "OTHER : 0 piece(s)\n";
        System.out.println(store.getProductsByCategory());
        assertEquals(excepted,store.getProductsByCategory());


    }
}