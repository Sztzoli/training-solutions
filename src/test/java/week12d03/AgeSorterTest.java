package week12d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AgeSorterTest {

    @Test
    void testSortAge() {
        int[] test = new int[]{9, 9, 8, 7, 5, 6, 4, 6, 3, 2, 1};
        AgeSorter ageSorter = new AgeSorter();
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertArrayEquals(result, ageSorter.sortAges(test));
    }

//    @Test
//    void testSortAge2() {
//        int[] test = new int[]{9, 9, 8, 7, 5, 6, 4, 6, 3, 2, 1};
//        AgeSorter ageSorter = new AgeSorter();
//        int[] result = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 9};
//        System.out.println(Arrays.toString(ageSorter.sortAges2(test)));
//
//        assertArrayEquals(result, ageSorter.sortAges2(test));
//    }

    @Test
    void testBubbleSort() {
        int[] test = new int[]{9, 9, 8, 7, 5, 6, 4, 6, 3, 2, 1};
        AgeSorter ageSorter = new AgeSorter();
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 9};

        assertArrayEquals(result,ageSorter.bubbleSort(test));
    }

    @Test
    void testShellSort() {
        int[] test = new int[]{9, 9, 8, 7, 5, 6, 4, 6, 3, 2, 1};
        AgeSorter ageSorter = new AgeSorter();
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 9};

        assertArrayEquals(result,ageSorter.shellSort(test));
    }

}