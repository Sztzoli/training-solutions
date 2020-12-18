package iofilestest.libary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testCreate() {
        Book book = new Book("testAuthor", "testTitle");
        assertEquals("testAuthor", book.getAuthor());
        assertEquals("testTitle", book.getTitle());
    }

}