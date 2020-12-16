package week08d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test
    void testShortest() {
        StringLists stringLists = new StringLists();
        List<String> shortList = stringLists.shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd"));

        assertEquals(List.of("aa","bb","dd"),shortList);

    }

}