package iofilestest.libary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library = new Library();
    private Book book1;
    private Book book2;

    @BeforeEach
    void init() {
        book1 = new Book("testAuthor1", "testTitle1");
        book2 = new Book("testAuthor2", "testTitle2");
    }

    @TempDir
    public File folder;

    @Test
    void add() {
        library.add(book1, book2);

        assertEquals(2, library.getBookList().size());
        assertEquals(book2, library.getBookList().get(1));

    }

    @Test
    void addSameBook() {
        library.add(book1, book2, book1);

        assertEquals(2, library.getBookList().size());
    }

    @Test
    void testSave() throws IOException {
        File file = new File(folder, "test.txt");
        Path path = file.toPath();
        library.add(book1, book2);
        library.saveBooks(path);

        List<Book> temp = new ArrayList<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                temp.add(new Book(parts[0], parts[1]));
            }
        }

        assertEquals(temp, library.getBookList());

    }

    @Test
    void testLoad() throws IOException {
        File file = new File(folder, "test.txt");
        Path path = file.toPath();
        List<String> temp = new ArrayList<>();
        String bookString1 = String.format("%s;%s",book1.getAuthor(), book1.getTitle());
        String bookString2 = String.format("%s;%s",book2.getAuthor(), book2.getTitle());
        temp.add(bookString1);
        temp.add(bookString2);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (String word : temp) {
                bufferedWriter.write(word+"\n");
            }
        }

        library.loadBooks(path);
        assertEquals(2, library.getBookList().size());
        assertEquals(book2, library.getBookList().get(1));

    }


}