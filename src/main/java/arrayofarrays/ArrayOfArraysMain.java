package arrayofarrays;

import java.time.LocalDate;

public class ArrayOfArraysMain {

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(4));
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());
        arrayOfArraysMain.printArrayOfArrays((arrayOfArraysMain.triangularMatrix(4)));


    }

    public int[][] multiplicationTable(int size) {
        int[][] array2D = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array2D[i][j] = (i + 1) * (j + 1);
            }

        }
        return array2D;
    }

    public void printArrayOfArrays(int[][] a) {
        for (int[] array1D : a
        ) {
            for (int elem : array1D
            ) {

                if (elem < 10) {
                    System.out.print("   " + elem);
                } else if (elem < 100) {
                    System.out.print("  " + elem);
                } else {
                    System.out.print(" " + elem);
                }

            }
            System.out.println("");
        }

    }

    public int[][] getValues() {
        int[][] array2D = new int[12][];
        System.out.println("Hónap napjai:");

        for (int i = 1; i <= array2D.length; i++) {
            LocalDate localDate = LocalDate.of(2020, i, 1);
            int days = localDate.getMonth().length(localDate.isLeapYear());
            array2D[i - 1] = new int[days];
            for (int j = 0; j < days; j++) {
                array2D[i - 1][j] = j;
            }
        }
        return array2D;

    }


    public int[][] triangularMatrix(int size) {

        int[][] a = new int[size][];

        for (int i = 0; i < size; i++) {
            a[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                a[i][j] = i;
            }
        }

        return a;
    }
}
