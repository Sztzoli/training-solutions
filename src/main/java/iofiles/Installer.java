package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class Installer {

    public void install(String pathFolder){
        Path folder = Path.of(pathFolder);
        if (!Files.exists(folder) || !Files.isDirectory(folder)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/install/install.txt")))) {
            String line;
            while (( line = bufferedReader.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(folder.resolve(line));
                } else {
                    Files.copy(this.getClass().getResourceAsStream("/install/" + line), folder.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }

            }
        } catch (IOException e) {
           throw new IllegalStateException("file can not read", e);
        }
    }
}
