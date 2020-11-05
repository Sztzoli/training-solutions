package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> memberList=new ArrayList<>();

    public List<Member> getMemberList() {
        return memberList;
    }

    public void addMember(String name){
        memberList.add(new Member(name));
    }

    public void connect(String name, String otherName){

        findByName(name).connectMember(findByName(otherName));


    }

    private Member findByName(String name){
        for (Member member: memberList
             ) {
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections(){
        List<String> bidirectionalConnections= new ArrayList<>();
        for (Member member: memberList
             ) {
            for (Member memberConnections: member.getConnections()
                 ) {
                if (memberConnections.getConnections().contains(member)){
                    bidirectionalConnections.add(member.getName() +"-"+ memberConnections);
                }
            }
        }
        return bidirectionalConnections;
    }


    @Override
    public String toString() {
        return  memberList.toString();
    }
}
