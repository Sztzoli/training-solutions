package week10d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HikingFile {

    public Result getPlusElevation(InputStream is) {
        Result result = new Result(0, 0);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            double temp = Double.parseDouble(reader.readLine().split(",")[2]);
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double num = temp - Double.parseDouble(parts[2]);
                if (num < 0){
                    result.addDec(Math.abs(num));
                } else {
                    result.addRise(num);
                }
                temp = Double.parseDouble(parts[2]);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file");
        }
        return result;
    }
}
