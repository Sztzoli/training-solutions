package week13d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnswerFileReaderTest {

    private final AnswerFileReader answerFileReader = new AnswerFileReader();

    @BeforeEach
    void initlist() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/week13d02/results.txt"));
        answerFileReader.read(reader);
    }


    @Test
    void testMap() {
        System.out.println(answerFileReader.getContestantMap());
        Map<String, Contestant> map = answerFileReader.getContestantMap();
        assertEquals(4, map.size());
        assertTrue(map.containsKey("AB123"));
        assertEquals("AB123", map.get("AB123").getId());
    }

    @Test
    void testCorrectAnswerById() {
        System.out.println(AnswerFileReader.correctAnswer);
        System.out.println(answerFileReader.getContestantMap().get("AB123").getAnswers());
        assertTrue(answerFileReader.correctAnswerById("AB123", 1));
        assertFalse(answerFileReader.correctAnswerById("AB123", 2));
    }

    @Test
    void testMostX() {
        assertEquals("BD452", answerFileReader.idWithMostX());
    }

    @Test
    void testWinner() {
        assertEquals("GH1234", answerFileReader.getMostScore());
    }


}