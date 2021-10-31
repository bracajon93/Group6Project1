package Grocery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MemberList {
	private static ArrayList<Member> memberList = new ArrayList<Member>();
	
	private static MemberList instance = null;

	private MemberList(){ /* private constructor for Singleton */

	}

	public static MemberList getInstance() {
        if (instance == null) {
            instance = new MemberList();
        }
        return instance;
    }
	
	public static boolean insertMember(Member member) {
		memberList.add(member);
		return true;
		
	}

	public static Member retrieveMember(int searchMemberID) {
		for (Iterator<Member> iterator = memberList.iterator(); iterator.hasNext();) {
            Member member = iterator.next();
            if (member.getID() == (searchMemberID)) {
                return member;
            }
        }
        return null;
	}
	
	public static Member retrieveMember(String searchMemberString) {
		for (Iterator<Member> iterator = memberList.iterator(); iterator.hasNext();) {
            Member member = iterator.next();
            while (member.getName().contains(searchMemberString)) {
                return member;
            }
            
        }
		return null;
	}
	
	public ArrayList<Member> getMembers() {
		return this.memberList;
	}

	public static void removeMember(Member member) {
		
	}

}
