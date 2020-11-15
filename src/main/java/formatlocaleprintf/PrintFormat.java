package formatlocaleprintf;

import java.util.Locale;
import java.util.MissingFormatArgumentException;

public class PrintFormat {



    public String printFormattedText(Double number) {
        String formatString = "Total is: %,.2f Ft";

        return String.format(new Locale("hu", "HU"), formatString, number);
    }
    public String printFormattedText(int i) {
        String str = "Right edge of numbers set at 4 spaces from text:%4d";
        return String.format( str, i);
    }

    public String printFormattedText(Integer i, Integer j, Integer k) {
        String str="Multiple objects containing text:%d\t%d\t%d";
        return String.format(str,i, j, k);
    }

    public String printFormattedText(int count, String fruit) {
        String str="We counted %d %s in the basket";
        return String.format(str,count,fruit.toUpperCase());
    }



    public String formatMessageWithIntegerParameters(String s, int i, int j) {
        try {
            return String.format(s, i ,j);
        } catch (MissingFormatArgumentException ex){
            throw new IllegalArgumentException("Less objects then expected in format String!", ex);
        }
    }
}
