package week11d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    void getLengthsTest() {
        NameLength nameLength = new NameLength();
        List<String> testList = List.of("Joe", "Jack", "Jane", "Jake", "George", "William");
        System.out.println(nameLength.getLengths(testList));
        assertEquals(2,nameLength.getLengths(testList).size());
        assertTrue(nameLength.getLengths(testList).contains(3));
    }

    @Test
    void getLengths2Test() {
        NameLength nameLength = new NameLength();
        List<String> testList = List.of("Joe", "Jack", "Jane", "Jake", "George", "William");
        System.out.println(nameLength.getLengths2(testList));
        assertEquals(2,nameLength.getLengths2(testList).size());
        assertTrue(nameLength.getLengths2(testList).contains(3));
        List<Integer> temp= nameLength.getLengths(testList);
        Collections.sort(temp);
        assertEquals(Arrays.asList(3,4), temp);
    }

}