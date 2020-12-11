package week03d04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @DisplayName("Creating a Phone object")
    @Test
    void testCreate() {
        Phone phone = new Phone("30", "1234567");

        assertEquals("30", phone.getPrefix());
        assertEquals("1234567", phone.getNumber());
    }
}