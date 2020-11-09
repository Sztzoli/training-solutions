package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public List<Integer> findDuplicates(List<Integer> element) {
        List<Integer> integerList=new ArrayList<>();
        for (int i = 1; i < element.size()-1; i++) {
            for (int j = 0; j < i; j++) {
                if (element.get(i).equals(element.get(j))){
                    integerList.add(element.get(i));
                    break;
                }
            }
        }
        return integerList;
    }
}
