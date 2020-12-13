package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> words, Path file) {
            try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
                for (String word : words) {
                    if (!word.startsWith("_")) {
                        outputStream.write(word.getBytes(StandardCharsets.UTF_8));
                    }
                }

            } catch (IOException ioe) {
                throw new IllegalStateException("Can not write file", ioe);
            }
    }
}
