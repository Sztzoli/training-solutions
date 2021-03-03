package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenDataCheckTest {

    private CitizenDataCheck dataCheck = new CitizenDataCheck();



    @Test
    void testCheckValidName() {
        assertTrue(dataCheck.checkName("Joe Doe"));
    }

    @Test
    void testCheckInvalidNameForBlank() {
        assertFalse(dataCheck.checkName("  "));
    }

    @Test
    void testCheckInvalidNameForNull() {
        assertFalse(dataCheck.checkName(null));
    }

    @Test
    void testCheckValidAge() {
        assertTrue(dataCheck.checkAge(11));
        assertTrue(dataCheck.checkAge(149));
    }

    @Test
    void testCheckInvalidAge() {
        assertFalse(dataCheck.checkAge(10));
        assertFalse(dataCheck.checkAge(150));
    }

    @Test
    void testCheckValidEmail() {
        assertTrue(dataCheck.checkEmail("asd@asd.hu"));
    }

    @Test
    void testCheckInvalidEmail() {
        assertFalse(dataCheck.checkEmail("asdasd.hu"));
        assertFalse(dataCheck.checkEmail("hu"));
    }

    @Test
    void testCheckValidTaj() {
        assertTrue(dataCheck.checkTaj("111111110"));
    }

    @Test
    void testCheckInvalidTaj() {
        assertFalse(dataCheck.checkTaj("111111100"));
    }

    @Test
    void testCheckValidZip() {
        assertTrue(dataCheck.checkZip("6000"));
    }

    @Test
    void testCheckInvalidZip() {
        assertFalse(dataCheck.checkZip("2001"));
    }




}