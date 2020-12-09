package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {
    private List<String> names = new ArrayList<>();

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {

        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                String str = String.format("%s: %d", name, TitleType.type(name).getSalary());
                printWriter.write(str+"\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);

        }
    }
}
