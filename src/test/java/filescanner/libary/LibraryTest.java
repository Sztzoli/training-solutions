package filescanner.libary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void testLoadFromFile() {
        Library library = new Library();

        library.loadFromFile();

        assertEquals(4, library.getBooks().size());
        assertEquals("Robert C. Martin", library.getBooks().get(2).getAuthor());
    }

}