package classstructureintagrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("name of Product:");
        String name = scanner.nextLine();

        System.out.println("price of product");
        int price = scanner.nextInt();

        Product product = new Product(name,price);
        System.out.println(product.printOut());
        product.increasePrice(24);
        System.out.println(product.printOut());
        product.decreasePrice(12);
        System.out.println(product.printOut());

    }
}
