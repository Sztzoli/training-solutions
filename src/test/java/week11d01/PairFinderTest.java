package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairsTest() {
        int[] array1 = {5, 1, 4, 5};
        int[] array2 = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(1, PairFinder.findPairs(array1));
        assertEquals(4, PairFinder.findPairs(array2));
    }

    @Test
    void findPairsMapTest() {
        int[] array1 = {5, 1, 4, 5};
        int[] array2 = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(1, PairFinder.findPairsMap(array1));
        assertEquals(4, PairFinder.findPairsMap(array2));
    }

}