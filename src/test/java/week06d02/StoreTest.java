package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        assertEquals(excepted,store.getProductsByCategory());


    }

    @Test
    void testExceptionList() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()->new Store(null));
        assertEquals("list can't be null or empty",ex.getMessage());
        Exception exSizeZero = assertThrows(IllegalArgumentException.class, ()->new Store(new ArrayList<>()));
        assertEquals("list can't be null or empty",exSizeZero.getMessage());

    }




}