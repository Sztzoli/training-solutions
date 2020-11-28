package objectclass;

import java.util.Objects;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        if (isEmpty(author) || isEmpty(title)){
            throw new IllegalArgumentException("author or title can't be null or blank");
        }
        this.author = author;
        this.title = title;
    }

    private boolean isEmpty(String str){
        if (str==null || str.isBlank()) {
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj==null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        if (!Objects.equals(author, book.author)) {
            return false;
        }

        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}
