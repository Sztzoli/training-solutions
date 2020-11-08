package controliteration.pi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PiGeneratorTest {

    @Test
    public void testCommaPlace() {
        String pi = new PiGenerator().PiGenerator();

        assertEquals(',',pi.charAt(1));
    }

    @Test
    public void testPiGenerator() {
        String pi = new PiGenerator().PiGenerator();
        double newPi =Double.parseDouble(pi.replace(',','.'));
        assertTrue(Math.abs(newPi - Math.PI) < 0.000001);

    }
}