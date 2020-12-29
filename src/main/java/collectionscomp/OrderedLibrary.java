package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    private List<Book> libraryBooks = new LinkedList<>();

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle(){
        List<Book> orderedList = new ArrayList<>(libraryBooks);
        Collections.sort(orderedList);
        return orderedList;
    }
    public List<Book> orderedByAuthor(){
        List<Book> orderedList = new ArrayList<>(libraryBooks);
        Collections.sort(orderedList,new AuthorComparator());
        return orderedList;
    }
    public List<String> orderedByTitleLocale(Locale locale){
        List<String> orderedList = new ArrayList<>();
        for (Book book : libraryBooks) {
            orderedList.add(book.getTitle());
        }
        Collections.sort(orderedList, Collator.getInstance(locale));
        return orderedList;
    }
}
