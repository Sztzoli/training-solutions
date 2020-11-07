package typeconversion.dataloss;

import javax.swing.*;

public class DataLoss {

    public void dataLoss() {
        int counter = 0;
        long number = 1;
        while (counter != 3) {
            float numberFloat = (float) number;
            long againLong = (long) numberFloat;
            if (againLong != number) {
                counter++;
                System.out.println(number + " float: " + numberFloat + " againlong:" + againLong);
                System.out.println(Long.toBinaryString(number)+" againlong:"+ Long.toBinaryString(againLong));
            }
            number++;
        }
    }

    public static void main(String[] args) {
        DataLoss dataLoss= new DataLoss();

        dataLoss.dataLoss();
    }
}
