package lambdastreams.bookstore;

public class Book {
    private String title;
    private int yearOfPublish;
    private int price;
    private int pieces;

    public Book(String title, int year, int price, int pieces) {
        this.title = title;
        this.yearOfPublish = year;
        this.price = price;
        this.pieces = pieces;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
}
