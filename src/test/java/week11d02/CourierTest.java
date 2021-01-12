package week11d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    private Path path;

    @TempDir
    public File folder;

    @BeforeEach
    void init() throws IOException {
        String s = "5 1 10\n" +
                "1 2 20\n" +
                "2 1 15\n" +
                "3 1 5\n" +
                "3 2 10\n" +
                "1 1 10";
        path = new File(folder, "test.txt").toPath();
        Files.writeString(path, s);

    }

    @Test
    void firstRideTest() {
        Courier courier = new Courier();
        courier.readFile(path);
        System.out.println(courier.firstRide());
    }

    @Test
    void gruopByKm() {
        Courier courier = new Courier();
        courier.readFile(path);
        courier.groupByKm();
    }

    @Test
    void workOffTest() {
        Courier courier = new Courier();
        courier.readFile(path);
        courier.workOff();
    }
}
