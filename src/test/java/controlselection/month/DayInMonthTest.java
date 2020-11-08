package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayInMonthTest {

    @Test
    void daysInMonth() {
        assertEquals(31,new DayInMonth().daysInMonth(2020,"Január"));
        assertEquals(30,new DayInMonth().daysInMonth(2020,"November"));
        assertEquals(29,new DayInMonth().daysInMonth(2020,"Február"));
        assertEquals(28,new DayInMonth().daysInMonth(2018,"Február"));
    }
}