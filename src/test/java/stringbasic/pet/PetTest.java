package stringbasic.pet;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    @Test
    public void testGetName() {
        Pet pet=new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "012345");

        assertEquals("János", pet.getName());
    }


    @Test
    public void testGetRegNumber() {
        Pet pet=new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "012345");



        assertEquals("012345", pet.getRegNumber());
        assertThrows(IllegalArgumentException.class, ()->new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "0012345"));
        assertThrows(IllegalArgumentException.class, ()->new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "001m45"));

    }
}