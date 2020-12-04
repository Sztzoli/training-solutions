package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    public void testCreatePet() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        bottle.fill(2);
        assertEquals(2, bottle.getFilledUntil());
        assertEquals(BottleType.PET_BOTTLE, bottle.getType());
    }

    @Test
    public void testCreateGlass() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        bottle.fill(1);
        assertEquals(1, bottle.getFilledUntil());
        assertEquals(BottleType.GLASS_BOTTLE, bottle.getType());
    }

    @Test
    public void testOverFlowGlass() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        Exception ex = assertThrows(IllegalArgumentException.class, ()-> bottle.fill(5));
        assertEquals("overflow", ex.getMessage());
    }

    @Test
    public void testOverFlowPet() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        Exception ex = assertThrows(IllegalArgumentException.class, ()-> bottle.fill(5));
        assertEquals("overflow", ex.getMessage());
    }

}