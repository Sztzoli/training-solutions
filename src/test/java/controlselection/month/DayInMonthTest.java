package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayInMonthTest {

    @Test
    void testDaysInMonth() {
        assertEquals(31,new DayInMonth().daysInMonth(2020,"Január"));
        assertEquals(30,new DayInMonth().daysInMonth(2020,"November"));
        assertEquals(29,new DayInMonth().daysInMonth(2020,"Február"));
        assertEquals(28,new DayInMonth().daysInMonth(2018,"Február"));

    }

    @Test
    public void testCase() {
        assertEquals(31,new DayInMonth().daysInMonth(2020,"JaNuár"));
    }

    @Test
    public void testLeapYear() {
        assertEquals(29,new DayInMonth().daysInMonth(2000,"Február"));
        assertEquals(28,new DayInMonth().daysInMonth(1900,"Február"));
    }

    @Test
    public void testIllegalMonth() {
        assertThrows(IllegalArgumentException.class, () -> new DayInMonth().daysInMonth(2020,"febrar"));
    }
}