package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] source, Path folder) {
        Path file = folder.resolve("image.png");
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))){
            for (int i = 0; i < source.length; i++) {
                outputStream.write(source[i]);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not write file");
        }
    }
}
