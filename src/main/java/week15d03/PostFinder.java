package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PostFinder {

    List<Post> postList;

    public PostFinder(List<Post> postList) {
        this.postList = new ArrayList<>(postList);
    }

    public List<Post> findPosts(String user) {
        Predicate<Post> publishBeforeNow =
                post -> post.getPublishedAt().isBefore(LocalDate.now());
        Predicate<Post> publishAfterNowFromUser =
                post -> post.getOwner().equals(user);
        Predicate<Post> emptyContentOrTitle =
                post -> !post.getContent().isBlank() && !post.getTitle().isBlank();
        Predicate<Post> deleteNullOrAfter =
                post -> post.getDeletedAt() == null || post.getDeletedAt().isAfter(LocalDate.now());
        return postList.stream().
                filter(publishBeforeNow.
                        or(publishAfterNowFromUser).
                        and(emptyContentOrTitle).
                        and(deleteNullOrAfter)).
                collect(Collectors.toList());

    }
}
