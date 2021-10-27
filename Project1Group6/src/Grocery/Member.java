package Grocery;

public class Member {
	String name;
	String address;
	long phoneNumber;
	int dateJoined;
	Double feePaid;
	int memberID;
	private static int idCounter = 456;
	
	public Member(String name, String address, long phoneNumber,
			int dateJoined, Double feePaid){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dateJoined = dateJoined;
		this.feePaid = feePaid;
		this.memberID = idCounter;
		idCounter++;
		
	}
	

}
