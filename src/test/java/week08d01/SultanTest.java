package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SultanTest {

    @Test
    void testone() {
        Sultan sultan = new Sultan(100);
        System.out.println(sultan.openDoors().toString());
    }

    @Test
    void testtwo() {
        Sultan sultan = new Sultan(100);
        System.out.println(sultan.easy());
    }

}