package software;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperSoftwareTest {

    @Test
    void test() {
        Software software = new DeveloperSoftware("name",100);
        software.increasePrice();
        assertEquals(110,software.getPrice(), 0.0001);
    }

}