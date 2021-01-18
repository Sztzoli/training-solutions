package week12d01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class GoodsPacker {

    public int packGoods(int[][] types, int capacity) {
        int result = 0;
        int actualCapacity = capacity;
        boolean isArrayEmpty = false;
        while (!isArrayEmpty) {
            int finalActualCapacity = actualCapacity;
            Optional<int[]> optionalArray = maxArray(types, finalActualCapacity);
            if (optionalArray.isEmpty()) {
                isArrayEmpty = true;
            } else {
                int [] actualMax = optionalArray.get();
                int value = actualCapacity/actualMax[0];
                result += (value*actualMax[1]);
                actualCapacity -= (value*actualMax[0]);
            }

        }
        return result;
    }

    private Optional<int[]> maxArray(int [][] types, int finalActualCapacity) {
        return Arrays.stream(types)
                .filter(value -> value[0] <= finalActualCapacity)
                .max(Comparator.comparingInt(value -> (finalActualCapacity/value[0])*value[1]));
    }

    public static void main(String[] args) {
        int[][] types = {{7, 160}, {3, 90}, {2, 15}};
        int capacity = 20;
        System.out.println(new GoodsPacker().packGoods(types, capacity));
    }
}
