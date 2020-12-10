package week07d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

    public static final String LINE_SEPARATOR = ";";
    List<Item> items = new ArrayList<>();

    public long calculateSum(String path) {
        Path file = Path.of(path);
        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(LINE_SEPARATOR);
                items.add(new Item(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }

        } catch (IOException e) {
            throw new IllegalStateException("can not read file");
        }
        return sumOfPrice();
    }

    private long sumOfPrice() {
        long sum = 0;
        for (Item item : items) {
            sum += item.getSumPrice();
        }
        return sum;
    }
}
