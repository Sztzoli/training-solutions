package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{
    private final String title;
    private final int length;
    private List<String> performers = new ArrayList<>();
    private List<String> composer = new ArrayList<>();


    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)){
            throw new IllegalArgumentException();
        }
        paramCheck(length);
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        this.composer = composer;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributions = new ArrayList<>();
        contributions.addAll(composer);

        contributions.addAll(performers);
        return contributions;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }





    private void paramCheck(int length) {
        if (length<0) {
            throw new IllegalArgumentException();
        }
    }



}
