package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path myFile;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String fileRealtivePath) {
        this.myFile = Path.of(fileRealtivePath);
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void readFromFile() {
        List<String> lines=null;
        try {
            lines= Files.readAllLines(myFile);
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
        initHumans(lines);

    }

    private void initHumans(List<String> lines) {
        for (String fullName : lines) {
            String firstName = fullName.substring(0, fullName.indexOf(" "));
            String lastName = fullName.substring(fullName.indexOf(" ") + 1);
            humans.add(new Human(firstName, lastName));
        }
    }
}
