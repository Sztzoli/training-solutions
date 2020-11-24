package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeLetterTest {

    @Test
    void testChangeVowels() {
        ChangeLetter changeLetter = new ChangeLetter();

        System.out.println(changeLetter.changeVowels("aeioukléáőúfg"));
        assertEquals("*****kléáőúfg",changeLetter.changeVowels("aeioukléáőúfg"));
    }

}