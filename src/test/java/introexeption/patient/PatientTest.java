package introexeption.patient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    public void testNameExceptionCatch() {

        assertThrows(IllegalArgumentException.class,()->new Patient("","fgr325346",2000));
    }

    @Test
    public void testYearExceptionCatch() {

        assertThrows(IllegalArgumentException.class,()->new Patient("Zoli","fgr325346",1890));
    }

    @Test
    public void testName() {
        Patient patient = new Patient("Zoli","111111110",1960);

        assertEquals("Zoli", patient.getName());
    }

    @Test
    public void testYear() {
        Patient patient = new Patient("Zoli","111111110",1960);

        assertEquals(1960, patient.getYearOfBirth());
    }

    @Test
    public void testSnnExceptionCatch() {

        assertThrows(IllegalArgumentException.class, ()-> new Patient("zoli","rt45zu",1960));
    }

}