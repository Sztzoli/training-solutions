package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                bands.add(new Band(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }


    public void writeBandsBefore(Path outputFile, int year) {
      try (  BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
          List<Band> olderThanList = olderThan(year);
          for (Band band : olderThanList) {
              writer.write(band.getName()+" "+band.getYear()+"\n");
          }
      } catch (IOException ioe) {
          throw new IllegalStateException("can not write file", ioe);
      }
    }

    private List<Band> olderThan(int year) {
        List<Band> olderThanList = new ArrayList<>();
        for (Band band : bands) {
            if (band.getYear() < year) {
                olderThanList.add(band);
            }
        }
        return olderThanList;
    }
}
