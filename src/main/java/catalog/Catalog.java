package catalog;


import java.util.ArrayList;
import java.util.List;

public class Catalog {
    public List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }


    public void deleteItemByRegistrationNumber(String registrationNumber) {
        catalogItems.remove(searchByRegNumber(registrationNumber));
    }

    private CatalogItem searchByRegNumber(String registrationNumber) {
        for (CatalogItem item : catalogItems) {
            if (registrationNumber.equals(item.getRegistrationNumber())) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }


    public double averagePageNumberOver(int limitPage) {
        if (limitPage < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int count = 0;
        int sum = 0;
        for (CatalogItem items : catalogItems) {
            if (items.numberOfPagesAtOneItem() > limitPage) {
                sum += items.numberOfPagesAtOneItem();
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / (double) count;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> list = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                list.add(item);
            }
        }
        return list;
    }


    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> list = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                list.add(item);
            }
        }
        return list;
    }


    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> searchedList = new ArrayList<>();

        for (CatalogItem item : catalogItems) {
            addContributors(searchCriteria, item, searchedList);
            addTitles(searchCriteria, item, searchedList);
        }
        return searchedList;
    }
    private void addContributors(SearchCriteria searchCriteria, CatalogItem item, List<CatalogItem> searchedList){
        if (searchCriteria.hasContributor() && searchBy(searchCriteria.getContributor(), item.getContributors())) {
            searchedList.add(item);
        }
    }

    private void addTitles(SearchCriteria searchCriteria, CatalogItem item, List<CatalogItem> searchedList) {
        if (searchCriteria.hasTitle() && searchBy(searchCriteria.getTitle(), item.getTitles())) {
            if (!searchedList.contains(item)) {
                searchedList.add(item);
            }
        }
    }


    private boolean searchBy(String searchCriteria, List<String> list) {
        for (String titles : list) {
            if (searchCriteria.equals(titles)) {
                return true;
            }
        }
        return false;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem item : catalogItems) {
            sum += item.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem item : catalogItems) {
            sum += item.fullLengthAtOneItem();
        }
        return sum;
    }


}
