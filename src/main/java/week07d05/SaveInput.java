package week07d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    public List<String>  init() {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("adj meg egy sort");
            String line = scanner.nextLine();
            lines.add(line);
        }
        System.out.println("adj meg a fájl nevét");
        String fileName = scanner.nextLine();
        lines.add(fileName);
        return lines;
    }

    public static void main(String[] args) {
        SaveInput saveInput = new SaveInput();
        List<String> lines = saveInput.init();
        String fileName = lines.get(3);
        List<String> linesWithoutName = lines.subList(0,3);
        Path file = Path.of("src/main/resources/week07d05/"+fileName+".txt");
        try {
            Files.write(file, linesWithoutName);
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file");
        }

    }
}
