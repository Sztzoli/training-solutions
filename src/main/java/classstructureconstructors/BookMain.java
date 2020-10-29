package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Kes János","Java");
        book.register("1564HG78");
        System.out.println(book.getAuthor()+": "+book.getTitle()+" "+ book.getRegNumber());
    }

}
