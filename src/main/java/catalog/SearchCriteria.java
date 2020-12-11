package catalog;

public class SearchCriteria {
    private final String contributor;
    private final String title;

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByTitle(String title) {
         if (Validators.isBlank(title)) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(null,title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(contributor, null);
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(contributor, title);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }


    public boolean hasTitle() {
        return title!=null;
    }


    public boolean hasContributor() {
        return contributor!=null;
    }
}
