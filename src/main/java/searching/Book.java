package searching;

public class Book implements Comparable<Book>{
    private int id;
    private String title;
    private String author;

    public Book(String author, String title) {
        this.title = title;
        this.author = author;
    }

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book o) {
        int i =this.author.compareTo(o.author);
        return i==0 ? this.title.compareTo(o.title): i;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s",id , author, title);
    }
}
