package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/ioreader/" + fileName);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                students.add(new Student(parts[0], convertTo(Arrays.copyOfRange(parts,1,parts.length))));
            }


        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private List<Integer> convertTo(String[] numbers) {
        List<Integer> grades= new ArrayList<>();
        for (String number : numbers) {
            grades.add(Integer.parseInt(number));
        }
        return grades;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public double classAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.average();
        }
        return sum/students.size();
    }
}
