package Grocery;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class Member {
	String name;
	String address;
	int phoneNumber;
	Calendar dateJoined;
	Double feePaid;
	int memberID;
	private static int idCounter = 456;

	public Member(String name, String address, int phoneNumber,
			Calendar dateJoined, Double feePaid){
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


}