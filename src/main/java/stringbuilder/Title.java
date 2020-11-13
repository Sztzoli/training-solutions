package stringbuilder;

public enum Title {
    MR("Mr."),
    MS("Ms."),
    PROF("Prof."),
    DR("Dr.");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
