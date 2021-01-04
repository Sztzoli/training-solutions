package week10d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void resultTest() {
        HikingFile hikingFile = new HikingFile();
        Result result = hikingFile.getPlusElevation();

        System.out.println(result.getRise());
        System.out.println(result.getDecrease());
    }

}