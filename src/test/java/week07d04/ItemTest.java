package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testCreate() {
        Item item = new Item("bread", 300, 2);
        assertEquals("bread", item.getName());
        assertEquals(300, item.getPrice());
        assertEquals(2, item.getAmount());
        assertEquals(600, item.getSumPrice());

    }

}