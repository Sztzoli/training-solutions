package week11d01;


import java.util.*;
import java.util.stream.Collectors;


public class PairFinder {

    public static int findPairs(int[] arr) {
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        for (int element : arr) {
            if (temp.contains(element)) {
                count++;
                temp.remove(Integer.valueOf(element));
            } else {
                temp.add(element);
            }
        }
        return count;
    }

    public static int findPairsMap(int[] arr) {
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Map<Integer, Long> integerMap = numbers.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        long value = integerMap.values().stream()
                .map(l -> l / 2)
                .mapToLong(Long::longValue)
                .summaryStatistics()
                .getSum();
        return (int) value ;
    }


}
