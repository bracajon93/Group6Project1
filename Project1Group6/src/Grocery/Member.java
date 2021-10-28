package Grocery;

import java.util.Scanner;

public class Member {

	Scanner scnr = new Scanner(System.in);

	private String name;
	private String address;
	private int phoneNumber;
	private int dateJoined;
	private Double feePaid;
	private int memberID;
	private static int idCounter = 0;

	public Member(String name, String address, int phoneNumber, int dateJoined, Double feePaid) {

		this.memberID = idCounter;
		idCounter++;

		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dateJoined = dateJoined;
		this.feePaid = feePaid;

	}

	public Member() {

		this.memberID = idCounter;
		idCounter++;

		System.out.println("Enter the name of the new member:");
		this.name = scnr.nextLine();

		System.out.println("Enter the address of the new member:");
		this.address = scnr.nextLine();

		System.out.println("Enter the phone number of the new member:");
		this.phoneNumber = scnr.nextInt();

		System.out.println("Enter the date joined of the new member:");
		this.dateJoined = scnr.nextInt();

		System.out.println("Enter the fee paid for the new member:");
		this.feePaid = scnr.nextLine();

	}

	public int getMemberID() {
		return this.memberID;
	}

	

}
