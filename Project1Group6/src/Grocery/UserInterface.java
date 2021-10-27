package Grocery;

import java.util.Scanner;

public class UserInterface {
	public static void main(String args[]) {
		int process = -1;
		
		Scanner input = new Scanner(System.in);
		
		while(process != 0) {
			System.out.println("Welcome to GROCERY!");
			System.out.println("Please make a selection");
			System.out.println("Enter 14 for HELP");
			System.out.println("Enter 0 to EXIT");
			System.out.println("Select option: ");
			process = input.nextInt();
			switch(process) {
			case 1:
				Member result;
				System.out.println("Enter name: ");
				System.out.println("Enter address: ");
				System.out.println("Enter phone number: ");
				System.out.println("Enter date joine (DD/MM/YYYY): ");
				System.out.println("Enter fee paid: ");
				String name = input.nextLine();
				input.nextLine();
				String address = input.nextLine();
				int phoneNumber = input.nextInt();
				int dateJoined = input.nextInt();
				double feePaid = input.nextDouble();
				result = Grocery.addMember(name, address, phoneNumber, dateJoined,
						feePaid);
				System.out.println(result);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				break;
			case 14:
				break;
			
			}
		}
	}


}
