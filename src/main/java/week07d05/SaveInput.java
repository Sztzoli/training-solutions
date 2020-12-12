package week07d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private Scanner scanner;

    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("adj meg egy sort");
            String line = scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

    private Path readFileName () {
        System.out.println("adj meg a fájl nevét");
        String fileName = scanner.nextLine();
        Path path = Path.of(fileName);
        return path;
    }




    public void write(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file",e);
        }
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.readLines();
        Path file = saveInput.readFileName();
        saveInput.write(file, lines);


    }
}
