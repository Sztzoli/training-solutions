package primitivetypes;

import java.util.Arrays;

public class PrimitiveTypes {
    public String toBinaryString(int n) {
        String binaryString = "";
        while (n!=0) {
            if (n % 2 == 0) {
                binaryString += 0;
            } else {
                binaryString += 1;
            }
            n /= 2;
        }
        String newBinaryString="";
        for (int i = binaryString.length()-1; i >-1 ; i--) {
            newBinaryString+=binaryString.charAt(i);
        }
        return newBinaryString;
    }


}
