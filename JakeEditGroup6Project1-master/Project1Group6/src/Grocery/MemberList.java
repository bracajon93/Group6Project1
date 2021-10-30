package Grocery;

import java.util.ArrayList;

public class MemberList {
	private ArrayList<Member> memberList = new ArrayList<Member>();

	private static MemberList instance = null;

	private MemberList() { /* private constructor for Singleton */

	}

	public static MemberList getInstance() {
		if (instance == null) {
			instance = new MemberList();
		}
		return instance;
	}

	public ArrayList<Member> getMembers() {
		return this.memberList;
	}

}
