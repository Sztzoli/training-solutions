package iofilestest.libary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<>();

    public void add(Book ... books) {
        for (Book book : books) {
            if (!bookList.contains(book)){
                bookList.add(book);
            }
        }
    }

    public void saveBooks(Path file) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            for (Book book : bookList) {
                String bufferString = String.format("%s;%s\n",book.getAuthor(),book.getTitle());
                bufferedWriter.write(bufferString);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not write file", ioe);
        }
    }

    public void loadBooks(Path file) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                add(new Book(parts[0], parts[1]));

            }

        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }

    public List<Book> getBookList() {
        return new  ArrayList(bookList);
    }
}
