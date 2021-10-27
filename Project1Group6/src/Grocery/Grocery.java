package Grocery;

public class Grocery {
	public static Member addMember(String name, String address, long phoneNumber,
			int dateJoined, Double feePaid) {
		Member member = new Member(name, address, phoneNumber, dateJoined,
				feePaid);
		if(MemberList.insertMember(member)) {
			return (member);
		}
		return null;
	}

}
