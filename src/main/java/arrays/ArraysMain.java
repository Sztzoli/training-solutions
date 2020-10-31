package arrays;

import arrays.ArraysMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMain {
    public int[] numberOfDaysPerMonths() {
        int[] a = new int[12];
        for (int i = 0; i < 12; i++) {
            LocalDate localDate = LocalDate.of(2020, (i + 1), 1);
            int days = localDate.getMonth().length(localDate.isLeapYear());
            a[i] = days;
        }
        return a;
    }


    public String numberOfDaysAsString(int[] a) {
        return Arrays.toString(a);

    }

    public List<String> daysOfWeek() {
        return Arrays.asList("hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap");


    }

    public String multiplicationTableAsString(int size) {
        int[][] array2D = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array2D[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(array2D);

    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {

        return Arrays.equals(day,anotherDay);
    }

    public boolean wonLottery(int[] a, int[] b) {
        int[] c = Arrays.copyOf(a, a.length);
        int[] d = Arrays.copyOf(b, b.length);
        Arrays.sort(c);
        Arrays.sort(d);
        return Arrays.equals(c, d);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        System.out.println(arraysMain.numberOfDaysAsString(arraysMain.numberOfDaysPerMonths()));

        System.out.println(arraysMain.daysOfWeek());

        System.out.println(arraysMain.multiplicationTableAsString(4));
        int[] a = new int[]{5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5};
        double[] day = new double[]{28, 30, 33, 45, 17, 12};
        double[] day2 = new double[]{0, 1, 2, 45, 4, 5};




        System.out.println(arraysMain.sameTempValues(day, day2));
        System.out.println(arraysMain.wonLottery(a, b));

    }

}

