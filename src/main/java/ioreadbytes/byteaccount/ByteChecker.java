package ioreadbytes.byteaccount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {


    public int readBytesAndFindAs(String pathString) {
        Path file = Path.of("src/main/resources/ioreadbytes/"+ pathString);
        int count = 0;
        try (InputStream inputStream = Files.newInputStream(file)){
            byte[] buffer = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(buffer))>0) {

                for (byte b : buffer){
                    if(b==97) {
                        count++;
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
        return count;

    }


}
