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
}