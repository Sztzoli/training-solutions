package week08d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    void test() {
        ExamplesStore examplesStore= new ExamplesStore();
        List<String> title  = examplesStore.getTitlesOfExamples();

        System.out.println(title);
    }

}