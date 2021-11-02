package Grocery;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class Member {
	String name;
	String address;
	String phoneNumber;
	Calendar dateJoined;
	String feePaid;
	int memberID;
	private static int idCounter = 0;

	public Member(String name, String address, String phoneNumber,
			Calendar dateJoined, String feePaid){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dateJoined = dateJoined;
		this.feePaid = feePaid;
		this.memberID = idCounter;
		idCounter++;

	}
	
	public static void retrieve(ObjectInputStream input) throws IOException, ClassNotFoundException {
        idCounter = (int) input.readObject();
    }
	
	public static void save(ObjectOutputStream output) throws IOException {
        output.writeObject(idCounter);
    }
	
	public int getID() {
		return memberID;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String memberString = "";
		memberString += "Member's address: " + address;
		memberString += " , fee paid: " + feePaid;
		memberString += ", member ID: " + Integer.toString(memberID);
		return memberString;
	}

	public String getDate() {
		String dateString = "";
		dateString += Integer.toString(dateJoined.get(Calendar.MONTH));
		dateString += "/";
		dateString += Integer.toString(dateJoined.get(Calendar.DAY_OF_MONTH));
		dateString += "/";
		dateString += Integer.toString(dateJoined.get(Calendar.YEAR));
		return dateString;
	}

}