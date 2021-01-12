package week11d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Courier {
    public static final String REGEX = " ";
    private List<Ride> rideList = new ArrayList<>();


    public void readFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(REGEX);
                int day = Integer.parseInt(parts[0]);
                int stopNumber = Integer.parseInt(parts[1]);
                int kilometer = Integer.parseInt(parts[2]);
                rideList.add(new Ride(day, stopNumber, kilometer));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public Ride firstRide() {
        List<Ride> temp = new ArrayList<>(rideList);
        temp.sort(Comparator.comparingInt(Ride::getDay).thenComparingInt(Ride::getStopNumber));
        return temp.get(0);
    }

    public Map<Integer, Integer> groupByKm() {
        List<Ride> temp = new ArrayList<>(rideList);
        Map<Integer, Integer> integerMap = temp.stream()
                .collect(Collectors.groupingBy(Ride::getDay, Collectors.summingInt(Ride::getKilometer)));
        return integerMap;
    }

    public void workOff() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        StringBuilder sb = new StringBuilder();
        for (int element : array) {
            if(!groupByKm().containsKey(element)) {
                sb.append(element).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
