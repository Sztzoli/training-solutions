package collectionsequalshash;

import java.util.Objects;

public class Book {
    private String regNumber;
    private String title;
    private String author;

    public Book(String regNumber, String title, String author) {
        this.regNumber = regNumber;
        this.author = author;
        this.title = title;
    }

    public Book(String title, String author ) {
        this.author = author;
        this.title = title;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
