package week12d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testCreate() {
        Client client = new Client("Zé", "1111");
        assertEquals("Zé", client.getName());
        assertEquals("1111", client.getRegNumber());
    }

}