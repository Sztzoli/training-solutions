package controlselection.accent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WithoutAccentsTest {

    @Test
     public void testWithoutAccents() {
        assertEquals('a',new WithoutAccents().withoutAccents('a'));
        assertEquals('a',new WithoutAccents().withoutAccents('á'));
    }
}