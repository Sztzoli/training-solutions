package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Track {
    public static final int BEGIN_INDEX_LAT = 12;
    public static final int END_INDEX_LAT = 22;
    public static final int BEGIN_INDEX_LON = 29;
    public static final int END_INDEX_LON = 39;
    public static final int BEGIN_INDEX_ELE = 5;
    public static final int END_INDEX_ELE = 10;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public double getFullElevation() {
        Elevation elevation = new Elevation();
        elevation.count();

        return elevation.elevation;
    }

    public double getFullDecrease() {
        Elevation elevation = new Elevation();
        elevation.count();

        return elevation.decrease;

    }

    public double getDistance() {
        double distance = 0.;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            distance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return distance;
    }

    public Coordinate findMinimumCoordinate() {

        return new Coordinate(lanStat().getMin(), longStat().getMin());
    }

    private DoubleSummaryStatistics lanStat() {
        return trackPoints.stream()
                .map(TrackPoint::getCoordinate)
                .mapToDouble(Coordinate::getLatitude)
                .summaryStatistics();

    }

    private DoubleSummaryStatistics longStat() {
        return trackPoints.stream()
                .map(TrackPoint::getCoordinate)
                .mapToDouble(Coordinate::getLongitude)
                .summaryStatistics();

    }


    public Coordinate findMaximumCoordinate() {

        return new Coordinate(lanStat().getMax(), longStat().getMax());
    }

    public double getRectangleArea() {
        return (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude())
                * (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());
    }


    public void loadFromGpx(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            Coordinate coordinate = null;
            TrackPoint trackPoint = null;
            while ((line = reader.readLine()) != null) {
                line=line.trim();
                if (line.startsWith("<trkpt")) {
                    double lat = Double.parseDouble(line.substring(BEGIN_INDEX_LAT, END_INDEX_LAT));
                    double lon = Double.parseDouble(line.substring(BEGIN_INDEX_LON, END_INDEX_LON));
                    coordinate = new Coordinate(lat, lon);
                }
                if (line.startsWith("<ele")) {
                    double ele = Double.parseDouble(line.substring(BEGIN_INDEX_ELE, END_INDEX_ELE));
                    trackPoint = new TrackPoint(coordinate, ele);
                }
                if (coordinate != null && trackPoint != null) {
                    trackPoints.add(trackPoint);
                    coordinate = null;
                    trackPoint = null;
                }

            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    private class Elevation {
        private double elevation = 0.;
        private double decrease = 0.;

        public double getElevation() {
            return elevation;
        }

        public double getDecrease() {
            return decrease;
        }

        public void count() {
            double preNumber = trackPoints.get(0).getElevation();
            for (int i = 1; i < trackPoints.size(); i++) {
                double actualNum = trackPoints.get(i).getElevation();
                if (preNumber < actualNum) {
                    elevation += (actualNum - preNumber);
                } else {
                    decrease += (preNumber - actualNum);
                }
                preNumber = actualNum;
            }
        }
    }
}
