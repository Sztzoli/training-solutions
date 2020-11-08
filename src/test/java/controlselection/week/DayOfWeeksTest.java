package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeeksTest {

    @Test
    public void testDayOfWeeks() {
        assertEquals("hét eleje",new DayOfWeeks().dayOfWeeks("hétfő"));
        assertEquals("hét közepe",new DayOfWeeks().dayOfWeeks("kedd"));
        assertEquals("hét közepe",new DayOfWeeks().dayOfWeeks("szerda"));
        assertEquals("hét közepe",new DayOfWeeks().dayOfWeeks("csütörtök"));
        assertEquals("majdnem hétvége",new DayOfWeeks().dayOfWeeks("péntek"));
        assertEquals("hét vége",new DayOfWeeks().dayOfWeeks("szombat"));
        assertEquals("hét vége",new DayOfWeeks().dayOfWeeks("vasárnap"));
    }

    @Test
    public void testCase(){
        assertEquals("hét vége",new DayOfWeeks().dayOfWeeks("szoMBat"));
    }

    @Test
    public void testIllegalDay(){
        assertThrows(IllegalArgumentException.class, ()->new DayOfWeeks().dayOfWeeks("tegnap"));
    }
}