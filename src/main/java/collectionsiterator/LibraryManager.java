package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber){
        Iterator<Book> i = libraryBooks.iterator();
        while (i.hasNext()){
            Book actualBook = i.next();
            if(regNumber==actualBook.getRegNumber()){
                return actualBook;
            }
        }
        throw new MissingBookException("No books found with regnumber: "+regNumber);
    }
    public int removeBookByRegNumber(int regNumber){
        Iterator<Book> i = libraryBooks.iterator();
        while (i.hasNext()){
            Book actualBook = i.next();
            if(regNumber==actualBook.getRegNumber()){
                i.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: "+regNumber);
    }
    public Set<Book> selectBooksByAuthor(String author){
        Set<Book> selectedBooks = new HashSet<>();
        Iterator<Book> iterator = libraryBooks.iterator();
        while (iterator.hasNext()){
            Book actualBook = iterator.next();
            if(author.equals(actualBook.getAuthor())){
                selectedBooks.add(actualBook);
            }
        }
        if (selectedBooks.isEmpty()){
            throw new MissingBookException("No books found by "+author);
        }
        return selectedBooks;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
