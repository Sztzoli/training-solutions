package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path myFile = Path.of(pathString);
        byte[] lines;
        try {
            lines = Files.readAllBytes(myFile);
            return new Temperatures(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }
}
