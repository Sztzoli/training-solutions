package week10d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void testResult() {
        Travel travel = new Travel();


        assertEquals("0", travel.getStopWithMax(Travel.class.getResourceAsStream("/utasadat.txt")));
    }

}