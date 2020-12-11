package week03d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneParserTest {

    @Test
    void testParse() {
        PhoneParser parser = new PhoneParser();
        Phone phone = parser.parse("10-1234567");

        assertEquals("10", phone.getPrefix());
        assertEquals("1234567", phone.getNumber());
    }

}