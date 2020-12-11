package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{
    private final String title;
    private final int numberOfPages;
    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        paramCheck(numberOfPages);
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }



    private void paramCheck(int numberOfPages) {
        if (numberOfPages<1) {
            throw new IllegalArgumentException();
        }
    }



    @Override
    public List<String> getContributors() {
        return List.copyOf(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
