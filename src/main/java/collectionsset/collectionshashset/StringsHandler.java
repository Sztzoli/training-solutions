package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {


    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        Set<String> filter = new HashSet<>(stringCollection);
        return filter;
    }
    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
        setA.retainAll(setB);
        return setA;
    }
}
