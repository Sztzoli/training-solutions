package objects;

import java.util.Arrays;
import java.util.List;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book();
        Book[] array = {new Book(),new Book(),new Book()};
        List<Book> list= Arrays.asList(new Book(), new Book(), new Book());

    }
}
