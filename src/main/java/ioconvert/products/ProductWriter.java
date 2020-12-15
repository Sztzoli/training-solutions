package ioconvert.products;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream outputStream, List<Product> products) {
        try (PrintStream printStream = new PrintStream(outputStream)) {
            for (Product product : products) {
                printStream.print(product.getName());
                printStream.print(";");
                printStream.print(product.getPrice());
                printStream.println();
            }

        }
    }
}
