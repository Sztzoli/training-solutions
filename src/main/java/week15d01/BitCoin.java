package week15d01;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class BitCoin {


    public Result bitCoinMinMax(List<Integer> exchangeRateList) {
        List<Integer> list = new ArrayList<>(exchangeRateList);
        return minMax(list);
    }

    private Result minMax(List<Integer> list) {


        Result result = new Result();
        while (list.size() >= 1) {
            int min = bitCoinStat(list).getMin();
            int indexMin = list.indexOf(Integer.valueOf(min));
            int lastIndex = list.size();
            int max = bitCoinStat(list.subList(indexMin, lastIndex)).getMax();
            result.valueOf(max, min);
            list.remove(indexMin);
        }
        return result;


    }

    private IntSummaryStatistics bitCoinStat(List<Integer> list) {
        return list.stream().
                mapToInt(Integer::intValue).
                summaryStatistics();
    }


    public static void main(String[] args) {
        System.out.println(new BitCoin().bitCoinMinMax(List.of(100, 120, 40, 70, 200, 30, 50)));
    }


}
