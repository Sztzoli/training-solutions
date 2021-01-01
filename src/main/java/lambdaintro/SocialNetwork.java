package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> memberList = new ArrayList<>();

    public SocialNetwork(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Member> findMembersBy(Predicate<Member> condition){
        List<Member> found = new ArrayList<>();
        for (Member member: memberList) {
            if (condition.test(member)){
                found.add(member);
            }
        }
        return found;
    }

    public void applyToSelectedMembers(Predicate<Member> condition, Consumer<Member> consumer) {
        for (Member member: memberList) {
            if (condition.test(member)){
                consumer.accept(member);
            }
        }
    }

    public <T> List<T> transformMembers(Function<Member, T> function){
        List<T> transformed = new ArrayList<>();
        for (Member member : memberList) {
            transformed.add(function.apply(member));
        }
        return transformed;
    }

    public List<Member> getMemberList() {
        return new ArrayList<>(memberList);
    }
}
