package introexeption.patient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SsnValidatorTest {

    @Test
    public void testisValidSsnLength() {
        assertFalse(new SsnValidator().isValidSsn("1111"));


    }

    @Test
    public void testisValidchar() {
        assertEquals(4,new SsnValidator().validateChar('4'));
    }

    @Test
    public void testisValidcharExceptionCatch() {
        char b='b';
        assertThrows(IllegalArgumentException.class, ()->new SsnValidator().validateChar(b));
    }
}