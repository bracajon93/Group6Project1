package Grocery;

import java.util.Scanner;

/**
 * A class to represent an individual Member
 */
public class Member {

    Scanner scnr = new Scanner(System.in);

    private static int idCount = 0;
    private int id;
    private String name;
    private String address;
    private int phoneNumber;
    private int dateJoined;
    private double feePaid;

    public  Member() {
        idCount++;
        this.id = idCount;

        System.out.println("What is the name of the new member?");
        this.name = scnr.nextLine();

        System.out.println("What is the address of the new memeber?");
        this.address = scnr.nextLine();

        System.out.println("What is the phone number of the new member?");
        this.phoneNumber = scnr.nextInt();

        System.out.println("What is the date? (mm/dd/yy)");
        this.dateJoined = scnr.nextInt();

        System.out.println("What is the fee paid by the new member?");
        this.feePaid = scnr.nextDouble();
    }

    public Member(String name, String address, int phoneNumber, int dateJoined, double feePaid){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateJoined = dateJoined;
        this.feePaid = feePaid;
    }

    public int getId() {
        return this.id;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getDateJoined() {
        return this.dateJoined;
    }

    public double getFeePaid() {
        return this.feePaid;
    }
}
