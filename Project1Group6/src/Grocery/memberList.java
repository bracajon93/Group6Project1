package Grocery;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;


public class memberList {
	Scanner scnr = new Scanner(System.in);

	private static memberList instance = null;

	private ArrayList<Member> listOfMembers = new ArrayList<Member>();

	private memberList(){ /* private constructor for Singleton */

	}

	public static memberList getInstance() {
        if (instance == null) {
            instance = new memberList();
        }
        return instance;
    }

	public void addMember() {
		Member tempMember = new Member();
		instance.listOfMembers.add(tempMember);
	}

	public void addMember(String name, String address, int phoneNumber, int dateJoined, Double feePaid) {
		Member tempMember = new Grocery.Member(name, address, phoneNumber, dateJoined, feePaid);
		instance.listOfMembers.add(tempMember);
	}

	public ArrayList<Member> getListOfMembers() {
		return instance.listOfMembers;
	}

	/* remove a member when given the id, buisness process 2 */
	/* does not  seem to require feedback/confirmation, but i put it there anyways*/
	public void removeMember(int id) {
		memberList tempInstance = memberList.getInstance();
		for (Member member : tempInstance.getListOfMembers()) {
			if (member.getMemberID() == id) {
				tempInstance.getListOfMembers().remove(member);
				System.out.println("Member removed.");
			}
		}
	}



}
