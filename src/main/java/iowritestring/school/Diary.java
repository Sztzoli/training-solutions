package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {

    public void newMark(Path file, int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, mark +"\n", StandardOpenOption.APPEND);
            }
            else {
                Files.writeString(file, Integer.toString(mark));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't open file", ioe);
        }
    }

    public void average(Path file){
        List<String> lines;
        try {
            lines = Files.readAllLines(file);
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
        int sum = 0;
        for (String line : lines) {
            sum += Integer.parseInt(line);
        }
        double average = sum/(double)lines.size();
        try {
            String str = String.format("average: %2.1f",average).replace(",",".");
            Files.writeString(file, str, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cant open file");
        }
    }
}
