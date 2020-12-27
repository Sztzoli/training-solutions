package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        for (Book book : books) {
            if (title.equals(book.getTitle()) &&
                    author.equals(book.getAuthor())) {
                return book;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book bookSearched) {
        for (Book book :books){
            if (book.equals(bookSearched)){
                return book;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> bookSet = new HashSet<>();
        for (Book book : books ) {
            bookSet.add(book);
        }
        return bookSet;
    }
}
