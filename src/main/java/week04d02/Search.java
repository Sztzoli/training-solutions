package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getIndexesOfChar(String word, char c) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (c == word.charAt(i)) {
                result.add(i);
            }
        }
        return result;
    }

}
