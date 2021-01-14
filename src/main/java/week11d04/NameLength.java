package week11d04;

import java.util.*;
import java.util.stream.Collectors;

public class NameLength {


    public static final String PREFIX = "J";

    public List<Integer> getLengths(List<String> nameList){
        Set<Integer> result = new TreeSet<>();
        result = nameList.stream()
                .filter(name -> name.startsWith(PREFIX))
                .map(String::length)
                .collect(Collectors.toSet());

        return new ArrayList<>(result);
    }

    public List<Integer> getLengths2(List<String> nameList){
        if (nameList==null) {
            throw new IllegalArgumentException("Empty list");
        }
        Set<Integer> result = new TreeSet<>();
        for (String word : nameList) {
            if (word!=null && word.startsWith(PREFIX)){
                result.add(word.length());
            }
        }
        return new ArrayList<>(result);
    }
}
