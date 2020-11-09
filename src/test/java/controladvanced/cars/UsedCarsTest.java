package controladvanced.cars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsedCarsTest {

    @Test
     public void testFilterLinesNormalCase() {
        UsedCars usedCars = new UsedCars();
        List<String> list = new ArrayList<>();
        list.add("ABC-123;2007;Volvo;red");

        assertEquals(Arrays.asList("ABC-123;2007;Volvo;red"), usedCars.filterLines(list));
    }

    @Test
    public void testFilterLinesWrongPlateMissingHyphen() {
        UsedCars usedCars = new UsedCars();
        List<String> list = new ArrayList<>();
        list.add("ABC123;2007;Volvo;red");

        assertEquals(new ArrayList<>(), usedCars.filterLines(list));
    }

    @Test
    public void testFilterLinesWrongPlateWrong() {
        UsedCars usedCars = new UsedCars();
        List<String> list = new ArrayList<>();
        list.add("ABC-1231;2007;Volvo;red");

        assertEquals(new ArrayList<>(), usedCars.filterLines(list));
    }

    @Test
    public void testFilterLinesYearBigger() {
        UsedCars usedCars = new UsedCars();
        List<String> list = new ArrayList<>();
        list.add("ABC-1231;2020;Volvo;red");

        assertEquals(new ArrayList<>(), usedCars.filterLines(list));
    }

    @Test
    public void testFilterLinesYearSmaller() {
        UsedCars usedCars = new UsedCars();
        List<String> list = new ArrayList<>();
        list.add("ABC-1231;1900;Volvo;red");

        assertEquals(new ArrayList<>(), usedCars.filterLines(list));
    }


}