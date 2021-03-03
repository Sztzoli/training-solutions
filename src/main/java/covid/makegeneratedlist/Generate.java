package covid.makegeneratedlist;

import covid.Citizen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {
    private List<Citizen> citizens = new ArrayList<>();
    private List<String> zipList = new ArrayList<>();
    private Random random = new Random();

    public Generate() {
        readFile("generatedPeople.csv");
        readFile("generatedPeople1.csv");
        readFile("generatedPeople2.csv");
        readFile("generatedPeople3.csv");
        readFile("generatedPeople4.csv");
        readFile("generatedPeople5.csv");
        readFile("generatedPeople6.csv");
        readZipFromFile();
        writeFile();
    }

    public void readFile(String pathString) {
        Path path = Path.of("src/main/resources/covid/" +pathString);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                citizens.add(new Citizen(
                        parts[0],
                        "2000",
                        Integer.parseInt(parts[2]),
                        parts[3],
                        "000000000"
                ));
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot read file", ioException);
        }
    }

    public void readZipFromFile() {
        Path path = Path.of("src/main/resources/covid/iranyitoszamok-varosok-2021.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                zipList.add(parts[0]);

            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot read file", ioException);
        }
    }

    public String generateTaj() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }
        String tajFirstEightDigit = sb.toString();
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int actualDigit = tajFirstEightDigit.charAt(i) - '0';
            if (i % 2 == 0) {
                result += (actualDigit * 3);
            } else {
                result += (actualDigit * 7);
            }

        }
        int lastDigit = result % 10;
        String taj = sb.append(lastDigit).toString();
        return taj;
    }

    public void writeFile() {
        Path path = Path.of("src/main/resources/covid/data.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Citizen citizen : citizens) {
                int index = random.nextInt(zipList.size());
                String line = String.format("%s,%s,%d,%s,%s", citizen.getName(), zipList.get(index), citizen.getAge(), citizen.getEmail(), generateTaj());
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot write file", ioException);
        }
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
    }


}
