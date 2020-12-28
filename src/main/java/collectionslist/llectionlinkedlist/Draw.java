package collectionslist.llectionlinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount>=maxNumber) {
            throw new IllegalArgumentException(String.format("drawCount must be less then %d!",maxNumber));
        }
        return new TreeSet<>(createNumberPool(maxNumber));
    }

    private List<Integer> createNumberPool(int maxNumber) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers;
    }
}
