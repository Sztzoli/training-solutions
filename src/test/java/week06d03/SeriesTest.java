package week06d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {


    @Test
    public void testAscending() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Series series = new Series();
        assertEquals("ASCENDING", series.calculateSeriesType(numbers).toString());
    }

    @Test
    public void testDescending() {
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        Series series = new Series();
        assertEquals("DESCENDING", series.calculateSeriesType(numbers).toString());
    }

    @Test
    public void testMixes() {
        List<Integer> numbers = Arrays.asList(6, 5, 7, 3, 2, 1);
        Series series = new Series();
        assertEquals("MIXED", series.calculateSeriesType(numbers).toString());
    }

    @Test
    public void testNull() {
        List<Integer> numbers =null;
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(numbers));
        assertEquals("Numbers can't be null or empty or one element", ex.getMessage());
    }

    @Test
    public void testEmpty() {
        List<Integer> numbers = Arrays.asList();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(numbers));
        assertEquals("Numbers can't be null or empty or one element", ex.getMessage());
    }

    @Test
    public void testOneElement() {
        List<Integer> numbers = Arrays.asList(1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(numbers));
        assertEquals("Numbers can't be null or empty or one element", ex.getMessage());
    }


}