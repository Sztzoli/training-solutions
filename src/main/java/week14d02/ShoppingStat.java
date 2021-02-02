package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShoppingStat {

    private Map<String, List<Purchase>> mapMap = new HashMap<>();

    public ShoppingStat(InputStream is) {
        readFromFile(is);
    }

    private void readFromFile(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String costumerId = line.substring(0, line.indexOf("-"));
                line = line.substring(line.indexOf("-") + 1);
                String id = line.substring(0, line.indexOf(":"));
                line = line.substring(line.indexOf(":") + 2);
                String[] items = line.split(",");
                List<Item> list = new ArrayList<>();
                for (String str : items) {
                    list.add(new Item(str));
                }
                Purchase purchase = new Purchase(id, list);
                List<Purchase> purchaseList = new ArrayList<>();
                purchaseList.add(purchase);
                mapMap.merge(costumerId,
                        purchaseList,
                        (prev, one) -> {
                            List<Purchase> purchaseList2 = new ArrayList<>(prev);
                            purchaseList2.addAll(one);
                            return purchaseList2;
                        }
                );
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot read", ioe);
        }

    }

    public long SumByPurchaseId(String id) {
        Purchase purchase = listSearch(id);

        return purchase.getItems().stream().
                mapToInt(Item::getPrice).summaryStatistics().getSum();
    }

    public long SumByCustomers(String id) {
        return mapMap.get(id).stream().map(Purchase::getItems)
                .flatMap(list -> list.stream())
                .mapToInt(Item::getPrice)
                .summaryStatistics()
                .getSum();
    }

    public List<Item> orderByPurchaseId(String custimerId, String shopId) {
        List<Purchase> purchaseList = mapMap.get(custimerId);
        Purchase purchase = purchaseList.stream().
                filter(value -> value.getId().equals(shopId))
                .findAny()
                .orElse(null);
        if (purchase != null) {
            List<Item> result = new ArrayList<>(purchase.getItems());
            result.sort(Comparator.comparing(Item::getName));
            return result;
        }
        throw new IllegalStateException("Not found");
    }

    private Purchase listSearch(String id) {
        for (List<Purchase> purchaseList : mapMap.values()) {
            for (Purchase purchase : purchaseList) {
                if (purchase.getId().equals(id)) ;
                return purchase;
            }
        }
        throw new IllegalStateException("Not found");
    }

    public long countByItemName(String termek) {
        return mapMap.values().stream().
                flatMap(l -> l.stream()).
                flatMap(l -> l.getItems().stream()).
                filter(value -> value.getName().equals(termek))
                .count();
    }

    public Map<String, Integer > statByName() {
        Map<String, Integer> result = new HashMap<>();
        Set<String> valami =
                mapMap.values().stream().
                        flatMap(l -> l.stream()).
                        flatMap(l->l.getItems().stream()).
                        map(Item::getName).
                        collect(Collectors.toSet());
        for (String termek : valami) {
            result.put(termek, (int)countByItemName(termek));
        }
        return result;
    }

    public static void main(String[] args) {
        ShoppingStat shoppingStat =
                new ShoppingStat(ShoppingStat.class.getResourceAsStream("file.txt"));
        System.out.println(shoppingStat.SumByPurchaseId("112"));
        System.out.println(shoppingStat.SumByCustomers("RA22"));
        System.out.println(shoppingStat.orderByPurchaseId("BK123","1211"));
        System.out.println(shoppingStat.countByItemName("bread"));
        System.out.println(shoppingStat.statByName());
    }


}
