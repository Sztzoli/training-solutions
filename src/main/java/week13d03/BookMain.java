package week13d03;

import java.util.*;
import java.util.stream.Collectors;

public class BookMain {

    public Optional<String> findAuthorWithPage(List<Book> books) {
        if (books.isEmpty()) {
           return Optional.empty();
        }
        Map<String, Integer> authorWithPageNumber = new HashMap<>();
        for (Book book : books) {
            String author = book.getAuthor();
//            if (!authorWithPageNumber.containsKey(author)) {
//                authorWithPageNumber.put(author, book.getNumberOfPages());
//            } else {
//                int sum = authorWithPageNumber.get(author);
//                sum = sum + book.getNumberOfPages();
//                authorWithPageNumber.put(author, sum);
//            }
//            int value =  authorWithPageNumber.getOrDefault(author,0);
//            value += book.getNumberOfPages();
//            authorWithPageNumber.put(author, value);
            authorWithPageNumber.merge(author,
                    book.getNumberOfPages(),
                    Math::max);
        }
        System.out.println(authorWithPageNumber);
        int maxNumberOfPages = 0;
        String author = null;
        for (Map.Entry<String, Integer> entry: authorWithPageNumber.entrySet()) {
            if (entry.getValue() > maxNumberOfPages) {
                maxNumberOfPages = entry.getValue();
                author = entry.getKey();
            }
        }
        return Optional.of(author);
    }


    public Optional<String> findAuthorWithPageWithStream(List<Book> books) {
        Map<String, Integer> m = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.summingInt(Book::getNumberOfPages)));
        m.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey);

        System.out.println(m);
        return null;

    }


    public static void main(String[] args) {
        Optional<String> result = new BookMain().findAuthorWithPageWithStream(List.of(
                new Book("xx","t1",10),
                new Book("xx","t1",20),
                new Book("yy","t1",5),
                new Book("zz","t1",6),
                new Book("zz","t1",3),
                new Book("zz","t1",12)
        ));
        System.out.println(result.isPresent());
        if (result.isPresent() ) {
            result.get();
        }
    }

}
