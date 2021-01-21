package week12d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ClientsTest {

    private Clients clients;

    @BeforeEach
    void init() {
        clients = new Clients(
                new Client("Zé", "1111"),
                new Client("Bé", "2222"),
                new Client("Cé", "3333"));
    }

    @Test
    void testInit() {

        assertEquals(3, clients.getClientMap().size());
        assertEquals("Bé", clients.getClientMap().get("2222").getName());
        assertEquals("2222", clients.getClientMap().get("2222").getRegNumber());

    }

    @Test
    void testFindRegNumber() {
        assertEquals("Bé", clients.findByRegNumber("2222").getName());
        assertEquals("2222", clients.findByRegNumber("2222").getRegNumber());
    }

    @Test
    void testFindRegNumberException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> clients.findByRegNumber("4444"));
        assertEquals("Client this regNumber: 4444 is not found", exception.getMessage());
    }

    @Test
    void testFindByName() {
        assertEquals(3,clients.findByName("é").size());
        assertEquals("Zé",clients.findByName("é").get(0).getName());
        assertEquals("1111",clients.findByName("é").get(0).getRegNumber());
    }
}
