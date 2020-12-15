package week08d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void testCreate() {
        Country country = new Country("test",1,2,3);

        assertEquals(new Country("test", 1, 2, 3), country);
    }

}