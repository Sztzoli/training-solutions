package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }

    public void addPhoto(String ... names) {
        for (String name : names) {
            photos.add(new Photo(name));
        }
    }


    public void starPhoto(String photo, Quality quality) {
        boolean find = false;
        for (Photo elem : photos) {
            if (photo.equals(elem.getName())) {
                find = true;
                elem.setQuality(quality);
            }
        }
        if (!find) {
            throw new PhotoNotFoundException();
        }
    }

    public int numberOfStars(){
        int count = 0;
        for (Photo elem : photos) {
            int actualStar = elem.getQuality().getValue();
            count += actualStar;
        }
        return count;
    }
}
