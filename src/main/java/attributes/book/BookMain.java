package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("söööör");
        System.out.println(book.getTitle());
        book.setTitle("söööööööööööööör");
        System.out.println(book.getTitle());
    }
}
