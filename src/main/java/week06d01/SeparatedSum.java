package week06d01;


import java.util.Scanner;

public class SeparatedSum {

    public Result sum(String s) {
        if (isEmpty(s)){
            throw new IllegalArgumentException("String can't be null or blank");
        }
        s=s.replace(",",".");
        Result result= new Result();
        Scanner sc = new Scanner(s).useDelimiter(";");

        while (sc.hasNext()) {
            result.add(sc.nextDouble());
        }
        return result;
    }

    private boolean isEmpty(String srt) {
        return srt == null || srt.isBlank();
    }
}
