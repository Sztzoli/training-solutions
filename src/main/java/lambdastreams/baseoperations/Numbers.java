package lambdastreams.baseoperations;



import java.util.Comparator;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


public class Numbers {
    private List<Integer> integerList;

    public Numbers(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public Optional<Integer> min() {
        return integerList.stream()
                .min(Comparator.naturalOrder());

    }

    public int sum() {
        return integerList.stream()
                .reduce(0,
                        Integer::sum,
                        Integer::sum
                );

    }

    public boolean isAllPositive() {
        return integerList.stream()
                .allMatch(integer -> integer>0);
    }


    public List<Integer> getDistinctElements() {
        return integerList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
