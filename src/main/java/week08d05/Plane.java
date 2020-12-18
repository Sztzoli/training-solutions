package week08d05;

import java.io.*;

public class Plane {




    public int readFile() {
        int maxLength = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("map.txt")))) {

            int size;
            int actualLength = 0;
            while ((size = bufferedReader.read()) > 0) {

                switch (size) {
                    case 48:
                        actualLength++;
                        break;
                    case 49:
                        if (maxLength < actualLength) {
                            maxLength = actualLength;
                        }
                        actualLength=0;
                        break;
                }

            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File can not read");

        }
        return maxLength;
    }



    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.readFile());
    }


}
