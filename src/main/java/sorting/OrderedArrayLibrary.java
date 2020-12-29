package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] sortedArray = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public Book[] sortingByTitle() {
        Book[] sortedArray = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(sortedArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return sortedArray;
    }
}
