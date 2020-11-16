package week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {

    @Test
    void changeFirstName() {
        NameChanger nameChanger= new NameChanger("Doe John");
        nameChanger.changeFirstName("Jack");
        assertEquals("Doe Jack",nameChanger.getFullName());
    }

    @Test
    void createNameChangerTest() {

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()->new NameChanger(""));
        assertThrows(IllegalArgumentException.class, ()->new NameChanger(null));
        assertEquals("Invalid Name: ", iae.getMessage());
    }
}