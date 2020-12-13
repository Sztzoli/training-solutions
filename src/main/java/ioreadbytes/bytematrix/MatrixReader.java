package ioreadbytes.bytematrix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private List<byte[]> myMatrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String pathString) {
        Path path = Path.of("src/main/resources/ioreadbytes/" + pathString);
        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] bytes = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                myMatrix.add(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

    public int numberOfColumnsWhereMoreZeros() {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            int countZero = 0;
            for (int j = 0; j < myMatrix.size(); j++) {

                if (myMatrix.get(j)[i] == 0) {
                    countZero++;
                }

            }
            if (countZero > myMatrix.size() / 2) {
                count++;
            }
        }
        return count;

    }

    //493 0 sor
    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/ioreadbytes/matrix.dat");
        byte[] bytes = new byte[1000];
        for (int i = 0; i < 1000; i++) {
            if (i < 493) {
                bytes[i] = 0;
            } else {
                bytes[i] = 1;
            }
        }
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (int i = 0; i < 9; i++) {
                outputStream.write(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not write file", ioe);
        }
    }
}
