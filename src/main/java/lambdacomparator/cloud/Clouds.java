package lambdacomparator.cloud;

import java.util.*;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorageList) {
//        List<CloudStorage> sorted = new ArrayList<>(cloudStorageList);
//        sorted.sort(Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
//        return sorted.get(0);
        return Collections.min(cloudStorageList, Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorageList) {
//        List<CloudStorage> sorted = new ArrayList<>(cloudStorageList);
//        sorted.sort(Comparator.comparing(CloudStorage::getPeriod,
//                Comparator.nullsFirst(Comparator.comparing(PayPeriod::getLength))).thenComparing(CloudStorage::getPrice));
//        return sorted.get(0);
        return Collections.min(cloudStorageList, Comparator.comparing(CloudStorage::getPeriod,
                Comparator.nullsFirst(Comparator.comparing(PayPeriod::getLength))).
                thenComparing(CloudStorage::getPrice));
    }


    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorageList) {
        List<CloudStorage> copyStorages = new ArrayList<>(cloudStorageList);
        copyStorages.sort(Comparator.reverseOrder());
        return copyStorages.subList(0, Math.min(copyStorages.size(), 3));
    }
}
