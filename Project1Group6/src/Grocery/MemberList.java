package Grocery;

import java.util.LinkedList;
import java.util.List;

public class MemberList {
	private static List<Member> memberList = new LinkedList<Member>();
	
	public static boolean insertMember(Member member) {
		memberList.add(member);
		return true;
		
	}
	

}
