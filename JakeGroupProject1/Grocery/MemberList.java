package Grocery;

import java.util.ArrayList;

/**
 * A class to hold an ArrayList of Member elements
 */
public class MemberList {

    private ArrayList<Member> memberArrayList;

    public MemberList(){
        memberArrayList = new ArrayList<Member>();
    }

    public ArrayList<Member> getMembers() {
        return this.memberArrayList;
    }
    
}
