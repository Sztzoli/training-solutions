package lambdaoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {

    List<Member> memberList = new ArrayList<>();

    public SocialNetwork(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        List<Member> found = new ArrayList<>();
        for (Member member : memberList) {
            if (predicate.test(member)) {
                found.add(member);
            }
        }
        if (found.size() != 0){
            return Optional.of(found.get(0));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<Double> averageNumberOfSkills() {
        if (memberList.isEmpty()){
            return Optional.empty();
        }
        int count=0;
        for (Member member : memberList) {
            count += member.getSkills().size();
        }
        return Optional.of ( (double) count/ memberList.size());
    }
}
