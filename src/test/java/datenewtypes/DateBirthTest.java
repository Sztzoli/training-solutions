package datenewtypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateBirthTest {

    @Test
    void testDateBirth() {
        DateBirth dateBirth = new DateBirth(1989, 9, 24);
        assertEquals("1989-09-24", dateBirth.getDate().toString());
    }

    @Test
    void testDateBirthString() {
        DateBirth dateBirth = new DateBirth("1989-09-24");
        assertEquals("1989-09-24", dateBirth.getDate().toString());
    }

    @Test
    void testFindDayOfWeek() {
        DateBirth dateBirth = new DateBirth(1989, 9, 24);
        assertEquals("vasárnap", dateBirth.findDayOfWeek());
    }

    @Test
    void testIsWeekDay() {
        DateBirth dateBirth = new DateBirth(1989, 9, 24);
        assertTrue(dateBirth.isWeekDay());
        DateBirth dateBirthFalse = new DateBirth(1989, 9, 25);
        assertFalse(dateBirthFalse.isWeekDay());
    }

    @Test
    void testWasItALeapYear() {
        DateBirth dateBirth = new DateBirth(1989, 9, 24);
        assertFalse(dateBirth.wasItALeapYear());
        DateBirth dateBirthLeap = new DateBirth(2020, 9, 24);
        assertTrue(dateBirthLeap.wasItALeapYear());
    }

    @Test
    void testFindBirthDayOfWeekLater() {
        DateBirth dateBirth = new DateBirth(1989, 9, 24);
        assertEquals("péntek", dateBirth.findBirthDayOfWeekLater(2021));
    }


}