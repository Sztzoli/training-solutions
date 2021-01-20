package timesheet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompanyFileWriter {

    public void write(Path file, String str){
        try {
            Files.writeString(file, str);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not write");
        }
    }
}
