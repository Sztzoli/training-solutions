package objects;

public class ObjectsMain {
    public static void main(String[] args) {

        System.out.println(new Book());
        Book emptyBook=null;
        System.out.println(emptyBook); //nem
        System.out.println(emptyBook==null);

        Book book=new Book();
        System.out.println(book);
        book=null;
        System.out.println(book);
        book = new Book();

        System.out.println(book);
        Book anotherBook = new Book();
        System.out.println(book==anotherBook);
        anotherBook=book;
        System.out.println(book==anotherBook);
        System.out.println(anotherBook instanceof Book);

    }
}
