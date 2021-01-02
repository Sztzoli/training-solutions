package lambdastreams.bookstore;



import java.util.*;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }


    public int getNumberOfBooks() {
        return books.stream().
                reduce(0,
                        (integer, book1) -> integer += book1.getPieces(),
                        Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return books.stream()
                .reduce(0,
                        (integer, book) -> integer += (book.getPrice()*book.getPieces()),
                        Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
