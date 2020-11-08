package controliteration.dictionary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {

    @Test
    public void testFindItem() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("sör", Arrays.asList("beer","pilsner"));

        List<String> translations=dictionary.findTranslations("sör");
        assertEquals(Arrays.asList("beer","pilsner"),translations);
    }

    @Test
    public void testAppendItem() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("sör", Arrays.asList("beer","pilsner"));
        dictionary.addItem("sör", Collections.singletonList("Lager"));

        List<String> translations=dictionary.findTranslations("sör");
        assertEquals(Arrays.asList("beer","pilsner","Lager"),translations);
    }

    @Test
    public void testAppendItemOnce(){
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("sör", Arrays.asList("beer","pilsner"));
        dictionary.addItem("sör", Collections.singletonList("Lager"));
        dictionary.addItem("sör", Collections.singletonList("Lager"));

        List<String> translations=dictionary.findTranslations("sör");
        assertEquals(Arrays.asList("beer","pilsner","Lager"),translations);
    }

    @Test
    public void testEmptyList() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("sör", Arrays.asList("beer","pilsner"));

        List<String> translations = dictionary.findTranslations("bor");
        assertEquals(new ArrayList<>(),translations);

    }
}