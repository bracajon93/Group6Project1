package Grocery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.BufferedReader;


public class UserInterface {
	private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Grocery grocery;
    private static final int EXIT = 0;
    private static final int ADD_MEMBER = 1;
    private static final int REMOVE_MEMBER = 2;
    private static final int ADD_PRODUCT = 3;
    private static final int CHECK_OUT = 4;
    private static final int PROCESS_SHIPMENT = 5;
    private static final int CHANGE_PRICE = 6;
    private static final int PRODUCT_INFO = 7;
    private static final int MEMBER_INFO = 8;
    private static final int PRINT_TRANSACTIONS = 9;
    private static final int OUTSTANDING_ORDERS = 10;
    private static final int SHOW_MEMBERS = 11;
    private static final int SHOW_PRODUCTS = 12;
    private static final int SAVE = 13;
    private static final int HELP = 14;
    
    
    private UserInterface() {
        if (yesOrNo("Look for saved data and  use it?")) {
            retrieve();
        } else {
            grocery = Grocery.instance();
        }

    }
    
    
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }
    
    public String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }
    
    private boolean yesOrNo(String prompt) {
        String more = getToken(prompt + " (Y|y)[es] or anything else for no");
        if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
            return false;
        }
        return true;
    }
    
    public int getNumber(String prompt) {
        do {
            try {
                String item = getToken(prompt);
                Integer number = Integer.valueOf(item);
                return number.intValue();
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a number ");
            }
        } while (true);
    }
    
    public Calendar getDate(String prompt) {
        do {
            try {
                Calendar date = new GregorianCalendar();
                String item = getToken(prompt);
                DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
                date.setTime(dateFormat.parse(item));
                return date;
            } catch (Exception fe) {
                System.out.println("Please input a date as mm/dd/yy");
            }
        } while (true);
    }
    
    public int getCommand() {
        do {
            try {
                int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
                if (value >= EXIT && value <= HELP) {
                    return value;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            }
        } while (true);
    }
    
    private void save() {
        if (grocery.save()) {
            System.out.println(" The grocery has been successfully saved in the file GroceryData \n");
        } else {
            System.out.println(" There has been an error in saving \n");
        }
    }
    
    private void retrieve() {
        try {
            if (grocery == null) {
                grocery = Grocery.retrieve();
                if (grocery != null) {
                    System.out.println(" The grocery has been successfully retrieved from the file GroceryData \n");
                } else {
                    System.out.println("File doesnt exist; creating new library");
                    grocery = Grocery.instance();
                }
            }
        } catch (Exception cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    public void help() {
        System.out.println("Enter a number between 0 and 12 as explained below:");
        System.out.println(EXIT + " to Exit\n");
        System.out.println(ADD_MEMBER + " to add a member");
        System.out.println(REMOVE_MEMBER + " to  remove a member");
        System.out.println(ADD_PRODUCT + " to  add a product");
        System.out.println(CHECK_OUT + " to  check out members' items ");
        System.out.println(PROCESS_SHIPMENT + " to process a shipment ");
        System.out.println(CHANGE_PRICE + " to  change the price of a product");
        System.out.println(PRODUCT_INFO + " to display product details");
        System.out.println(MEMBER_INFO + " to  display member details");
        System.out.println(PRINT_TRANSACTIONS + " to print members transactions give to date inputs");
        System.out.println(OUTSTANDING_ORDERS + " to  display any outstanding orders");
        System.out.println(SHOW_MEMBERS + " to list all the members");
        System.out.println(SHOW_PRODUCTS + " to list all the products");
        System.out.println(SAVE + " to  save data");
        System.out.println(HELP + " for help");
    }
    
    public void process() {
        int command;
        help();
        while ((command = getCommand()) != EXIT) {
            switch (command) {
            case ADD_MEMBER:
            	add_member();
                break;
            case REMOVE_MEMBER:
                break;
            case ADD_PRODUCT:
                break;
            case CHECK_OUT:
                break;
            case PROCESS_SHIPMENT:
                break;
            case CHANGE_PRICE:
                break;
            case PRODUCT_INFO:
                break;
            case MEMBER_INFO:
                break;
            case PRINT_TRANSACTIONS:
                break;
            case OUTSTANDING_ORDERS:
                break;
            case SHOW_MEMBERS:
                break;
            case SHOW_PRODUCTS:
                break;
            case SAVE:
                save();
                break;
            case HELP:
                help();
                break;
            }
        }
    }
    
    private void add_member() {
    	Scanner scnr = new Scanner(System.in);
    	System.out.println("Enter the name of the new member:");
		String name = scnr.nextLine();

		System.out.println("Enter the address of the new member:");
		String address = scnr.nextLine();

		System.out.println("Enter the phone number of the new member:");
		int phoneNumber = scnr.nextInt();

		System.out.println("Enter the date joined of the new member:");
		Calendar dateJoined = getDate("Please enter the date: ");
		
		System.out.println("Enter the fee paid for the new member:");
		double feePaid = scnr.nextDouble();
		Member result = Grocery.addMember(name, address, phoneNumber, dateJoined,
				feePaid);
		System.out.println(result);
		
	}


	public static void main(String[] args) {
        UserInterface.instance().process();
    }

		
		
}




