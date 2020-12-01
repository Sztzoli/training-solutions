package week06d01;


import java.util.Scanner;

public class SeparatedSum {

    public static final String SOURCE = ",";
    public static final String TARGET = ".";

    public Result sum(String s) {
        if (isEmpty(s)){
            throw new IllegalArgumentException("String can't be null or blank");
        }
        s=s.replace(SOURCE, TARGET);
        Result result= new Result();
        Scanner sc = new Scanner(s).useDelimiter(";");

        while (sc.hasNext()) {
            result.add(Double.parseDouble(sc.next()));
        }
        return result;
    }

    private boolean isEmpty(String srt) {
        return srt == null || srt.isBlank();
    }
}
