package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {


    @Test
    void testCreate() {
        Citizen citizen = new Citizen("John Doe","2000",30,"vlalami@mail.com","111111110");
        assertEquals("John Doe", citizen.getName());
        assertEquals("2000", citizen.getZip());
        assertEquals(30, citizen.getAge());
        assertEquals("vlalami@mail.com", citizen.getEmail());
        assertEquals("111111110", citizen.getTaj());
        assertEquals(0, citizen.getNumberOfVaccination());
        assertNull(citizen.getLastVaccinationDate());
    }

    @Test
    void testAddVaccination() {
        Citizen citizen = new Citizen("John Doe","2000",30,"vlalami@mail.com","111111110");
        citizen.addVaccination();
        assertEquals(1, citizen.getNumberOfVaccination());
        citizen.addVaccination();
        assertEquals(2, citizen.getNumberOfVaccination());
    }

    @Test
    void testAddVaccinationThrowException() {
        Citizen citizen = new Citizen("John Doe","2000",30,"vlalami@mail.com","111111110");
        citizen.addVaccination();
        citizen.addVaccination();
        Exception ex = assertThrows(IllegalStateException.class, () -> citizen.addVaccination());
        assertEquals("Citizen have already two vaccination", ex.getMessage());
    }


    @Test
    void testNameExceptionThrow() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("","2000",30,"vlalami@mail.com","111111110"));
        assertEquals("Name can not be empty", ex.getMessage());
    }

    @Test
    void testAgeExceptionThrow() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("John Doe","2000",10,"vlalami@mail.com","111111110"));
        assertEquals("Invalid age: 10, age is between 1 and 150", ex.getMessage());
    }

    @Test
    void testTajExceptionThrow() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("John Doe","2000",15,"vlalami@mail.com","111111100"));
        assertEquals("Invalid TAJ: 111111100", ex.getMessage());
    }

    @Test
    void testTajExceptionThrowNotDigit() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("John Doe","2000",15,"vlalami@mail.com","a11111100"));
        assertEquals("Invalid TAJ: a11111100", ex.getMessage());
    }

    @Test
    void testTajExceptionThrowWrongLength() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("John Doe","2000",15,"vlalami@mail.com","11111110"));
        assertEquals("Invalid TAJ: 11111110", ex.getMessage());
    }

    @Test
    void testEmailExceptionThrowWrongLength() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("John Doe","2000",30,"a@","111111110"));
        assertEquals("Invalid email: a@", ex.getMessage());
    }

    @Test
    void testEmailExceptionThrowMissing() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->new Citizen("John Doe","2000",30,"ah.hu","111111110"));
        assertEquals("Invalid email: ah.hu", ex.getMessage());
    }





}