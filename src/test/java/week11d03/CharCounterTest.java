package week11d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void charCounterTest() {
        CharCounter charCounter = new CharCounter();
        String[] testArray = {"abc", "cba", "ab"};
        System.out.println(charCounter.countChars1(testArray));
        assertEquals(2, charCounter.countChars1(testArray));
    }

}