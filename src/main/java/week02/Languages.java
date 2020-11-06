package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> programLang=new ArrayList<>();
        programLang.add("Java");
        programLang.add("Python");
        programLang.add(("JavaScript"));

        for (String elem: programLang
             ) {
            if(elem.length()>5){
                System.out.println(elem);
            }
        }
    }
}
