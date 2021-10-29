package Grocery;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MemberList {
	private static List<Member> memberList = new LinkedList<Member>();
	
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

	public static void removeMember(Member member) {
		
	}

}
