package week12d03;

import java.util.*;

public class AgeSorter {

    public int[] sortAges(int[] ages) { //ismétlés nélkül jó
        int[] result;
        Integer[] agesInteger = Arrays.stream(ages).boxed().toArray(Integer[]::new);
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(agesInteger));
        Integer[] array = integerSet.toArray(Integer[]::new);
        result = Arrays.stream(array).mapToInt(value -> value).toArray();
        return result;
    }

    public int[] sortAges2(int[] ages) { //nem jó
        int[] result;
        Integer[] agesInteger = Arrays.stream(ages).boxed().toArray(Integer[]::new);
        Queue<Integer> integerPriorityQueue=new PriorityQueue<>(Arrays.asList(agesInteger));
        Integer[] array = integerPriorityQueue.toArray(Integer[]::new);
        result = Arrays.stream(array).mapToInt(value -> value).toArray();
        return result;
    }

    public int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }

    public int[] shellSort(int arrayToSort[]) {
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
        return arrayToSort;
    }



}
