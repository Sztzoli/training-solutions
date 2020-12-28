package collectionsset.collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings){
        Set<String> filter = new TreeSet<>();
        for (String word : randomStrings) {
            filter.add(word);
        }
        return filter;
    }

}
