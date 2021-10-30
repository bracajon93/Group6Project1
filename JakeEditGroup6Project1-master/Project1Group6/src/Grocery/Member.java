package Grocery;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Member {

	Scanner scnr = new Scanner(System.in);

	String name;
	String address;
	String phoneNumber;
	Date dateJoined;
	String feePaid;
	int memberID;
	private static int idCounter = 0;

	public Member() {
		this.memberID = idCounter;
		memberID++;

		System.out.println("What is the name of the new member?");
		this.name = scnr.nextLine();

		System.out.println("What is the address of the new memeber?");
		this.address = scnr.nextLine();

		System.out.println("What is the phone number of the new member?");
		this.phoneNumber = scnr.nextLine();

		this.dateJoined = new Date();

		System.out.println("What is the fee paid by the new member?");
		this.feePaid = scnr.nextLine();
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

}