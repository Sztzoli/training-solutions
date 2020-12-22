package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    void testSum() {
        FibCalculator fibCalculator = new FibCalculator();

        System.out.println(fibCalculator.sumEvents(10));
        System.out.println(fibCalculator.sumEvents2(35));


    }

}