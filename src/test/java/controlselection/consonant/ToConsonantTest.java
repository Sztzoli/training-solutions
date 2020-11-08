package controlselection.consonant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToConsonantTest {

    @Test
    public void testToConsonantLowerCase() {
        assertEquals('e',new ToConsonant().toConsonant('a'));
        assertEquals('a',new ToConsonant().toConsonant('u'));
    }

    @Test
    public void testToConsonantUpperCase() {
        assertEquals('E',new ToConsonant().toConsonant('A'));
    }

    @Test
    public void testToVowelCase() {
        assertEquals('b',new ToConsonant().toConsonant('b'));
    }


}