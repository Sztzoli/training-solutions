package week14d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Transformers {

    public <T, R> List<R> map(List<T> list, Function<T, R> transformer) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(transformer.apply(item));
        }
        return result;
    }

    public <T> T reduce(List<T> list, T identity, BiFunction<T, T, T> combiner) {
        T result = identity;
        for (T item : list) {
            result = combiner.apply(result, item);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Transformers().map(Arrays.asList(1, 2, 3), value -> value +1 ));
        System.out.println(new Transformers().reduce(Arrays.asList(1 ,2 ,3),0,Integer::sum));
    }

//
//    Mai senior feladat:
//    Irj egy Transformers osztályt, melynek van két metódusa:
//    public <T, R> List<R> map(List<T> list, Function<T, R> transformer)
//    és public <T> T reduce(List<T> list, T identity, BiFunction<T, T, T> combiner).
//    A feladat az, hogy a map metódus visszaadjon egy új listát, melyben a megadott list elemeinek a transformer lambdaval transzformált változata található,
//    illetve a reduce esetében a megadott lista combiner lambdával kombinált értéke található. Használjuk az identity-t kezdőértéknek! Irjunk teszteket is!
//    Példa:
//            System.out.println(new Transformers().map(Arrays.asList(1, 2, 3), (value) -> value + 1));
//// [2, 3, 4]
//System.out.println(new Transformers().reduce(Arrays.asList(1, 2, 3), 0, Integer::sum));
//// 6

}
