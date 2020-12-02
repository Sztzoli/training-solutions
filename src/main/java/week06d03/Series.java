package week06d03;

import java.util.ArrayList;
import java.util.List;

public class Series {

    public SequenceState calculateSeriesType(List<Integer> numbers) {
        if (numbers==null || numbers.size()==0 || numbers.size()==1){
            throw new IllegalArgumentException("Numbers can't be null or empty or one element");
        }
        SequenceState initialState = calculateTwoItem(numbers.get(0),numbers.get(1));
        for (int i = 1; i < numbers.size()-1; i++) {
            if (initialState!=calculateTwoItem(numbers.get(i),numbers.get(i+1))){
                return SequenceState.MIXED;
            }
        }
        return initialState;
    }

    private SequenceState calculateTwoItem(int a,int b) {
        if (a<b) {
            return SequenceState.ASCENDING;
        }
        return SequenceState.DESCENDING;
    }
}
