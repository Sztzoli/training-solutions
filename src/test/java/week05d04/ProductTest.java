package week05d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    private Product product;


    @BeforeEach
    public void setUp() {
        this.product = new Product(1000, "huf");
    }

    @DisplayName("When Product object initialize")
    @Test
    void testCreate() {

        assertEquals(Currency.HUF, product.getCurrency());
        assertEquals(1000, product.getPrice());
    }

    @DisplayName("Convert to different currency")
    @Test
    void testConvertPrice() {

        assertEquals(1000, product.convertPrice(Currency.HUF));
        assertEquals(1000 / 300d, product.convertPrice(Currency.USD));

    }


    @Test
    void testException() {

        Exception exNull = assertThrows(IllegalArgumentException.class, () -> new Product(1000,null).getCurrency());
        assertEquals("Currency is wrong", exNull.getMessage());

        Exception exWrongCurrency = assertThrows(IllegalArgumentException.class, () -> new Product(1000,"EUR").getCurrency());
        assertEquals("Currency is wrong", exWrongCurrency.getMessage());

        Exception exWrongPrice = assertThrows(IllegalArgumentException.class, ()-> new Product(-1000,"huf"));
        assertEquals("price is wrong", exWrongPrice.getMessage());
    }


}