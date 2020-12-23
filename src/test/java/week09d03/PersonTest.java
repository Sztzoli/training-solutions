package week09d03;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;


    @BeforeEach
    void init() {
        person = new Person("Zé", 14);

    }

    @Test
    void createTest() {

        assertEquals(new Person("Zé", 14), person);
    }

    @Test
    void setPresentBelow14Test() {
        person.setPresent(new Random(1));

        assertNotNull(person.getPresent());
        assertTrue(Arrays.asList(Present.values()).contains(person.getPresent()));
        assertEquals(Present.HOUSEKEEPING, person.getPresent());
    }

    @Test
    void setPresentOver14Test() {
        Person olderPerson = new Person("Jé", 15);
        person.setPresent(new Random(1));
        assertNull(olderPerson.getPresent());
    }
}