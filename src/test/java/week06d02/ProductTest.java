package week06d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testCreate() {
        Product product = new Product("sör", Category.OTHER, 250);
        assertEquals("sör", product.getName());
        assertEquals(Category.OTHER, product.getCategory());
        assertEquals(250, product.getPrice());
    }

    @Test
    void testException() {
        Exception exNamenull = assertThrows(IllegalArgumentException.class, () -> new Product(null, Category.OTHER, 250));
        assertEquals("name can't be null or blank", exNamenull.getMessage());
        Exception exNameEmpty = assertThrows(IllegalArgumentException.class, () -> new Product("   ", Category.OTHER, 250));
        assertEquals("name can't be null or blank", exNameEmpty.getMessage());
        Exception exPriceNegative = assertThrows(IllegalArgumentException.class, () -> new Product("sör", Category.OTHER, -1));
        assertEquals("price can't be negative", exPriceNegative.getMessage());
    }

}