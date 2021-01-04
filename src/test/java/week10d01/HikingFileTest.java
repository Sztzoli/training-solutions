package week10d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void resultTest() {
        HikingFile hikingFile = new HikingFile();
        Result result = hikingFile.getPlusElevation(HikingFile.class.getResourceAsStream("/gps.txt"));

        assertEquals(10, result.getRise());
        assertEquals(20, result.getDecrease());


    }

}