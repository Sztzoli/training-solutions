package week07d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {



    @Test
    void testDateOF() {
        Date date = Date.of(2020,12,9);
        assertEquals(2020, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(9, date.getDay());

    }

    @Test
    void testWith() {
        Date date = Date.of(2020,12,9);

        assertEquals(Date.of(2010,10,10), date.withYear(2010).withMonth(10).withDay(10));
    }


}