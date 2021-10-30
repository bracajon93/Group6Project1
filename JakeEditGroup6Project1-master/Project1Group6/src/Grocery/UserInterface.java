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



public class UserInterface {
	private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Grocery grocery;
    Scanner scnr = new Scanner(System.in);
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
        // System.out.println(CHECK_OUT + " to  check out members' items ");
        // System.out.println(PROCESS_SHIPMENT + " to process a shipment ");
        System.out.println(CHANGE_PRICE + " to  change the price of a product");
        System.out.println(PRODUCT_INFO + " to search for a product");
        System.out.println(MEMBER_INFO + " to  search for a member");
        // System.out.println(PRINT_TRANSACTIONS + " to print members transactions give to date inputs");
        // System.out.println(OUTSTANDING_ORDERS + " to  display any outstanding orders");
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
            	remove_member();
                break;
            case ADD_PRODUCT:
            	add_product();
                break;
            case CHECK_OUT:
            	check_out();
                break;
            case PROCESS_SHIPMENT:
                break;
            case CHANGE_PRICE:
            	change_price();
                break;
            case PRODUCT_INFO:
            	product_info();
                break;
            case MEMBER_INFO:
            	member_info();
                break;
            case PRINT_TRANSACTIONS:
            	print_transactions();
                break;
            case OUTSTANDING_ORDERS:
            	outstanding_orders();
                break;
            case SHOW_MEMBERS:
            	show_members();
                break;
            case SHOW_PRODUCTS:
            	show_products();
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
    


	private void show_products() {
        grocery.getProductList();
        for (Product product : ProductList.getInstance().getProductList()) {
            System.out.println("Product: " + product.getName() + "\nID: " + product.getID() + "\nQuantity: " + product.getQuantity() + "\nPrice: " + product.getPrice() + "\nReorder level: " + product.getReorderLevel());
            System.out.println(); /* don't delete */
        }
	}


	private void show_members() {
        grocery.getMemberList();
        for (Member member : MemberList.getInstance().getMembers()) {
            System.out.println("Name: " + member.getName() + "\nDate joined: " + member.dateJoined.toString() + "\nAddress: " + member.address + "\nPhone number: " + member.phoneNumber);
        }
	}


	private void outstanding_orders() {
	}


	private void print_transactions() {
	}


	private void member_info() {
        System.out.println("What should we be searching for?");
        String tempString = scnr.nextLine();
		grocery.getMemberList();
        for (Member member : MemberList.getInstance().getMembers()) {
            if (member.getName().startsWith(tempString)) {
                System.out.println("Name: " + member.getName() + "\nDate joined: " + member.dateJoined.toString() + "\nAddress: " + member.address + "\nPhone number: " + member.phoneNumber);
            }
        }
		
	}


	private void check_out() {
	}


	private void product_info() {
        System.out.println("What should we be searching for?");
        String tempString = scnr.nextLine();
        grocery.getProductList();
        for (Product product : ProductList.getInstance().getProductList()) {
            if (product.getName().startsWith(tempString)) {
                System.out.println("Product: " + product.getName() + "\nID: " + product.getID() + "\nQuantity: " + product.getQuantity() + "\nPrice: " + product.getPrice() + "\nReorder level: " + product.getReorderLevel());
                System.out.println();
            }
        }
	}


	/* Use case 6 */
    private void change_price() {
		System.out.println("What is the id of the product whose price you would like to change?");
        int tempId = scnr.nextInt();
        grocery.getProductList();
        for (Product product : ProductList.getInstance().getProductList()) {
            if (product.getID() == tempId) {
                System.out.println("What is the new price?");
                String temp = scnr.next();
                product.setPrice(temp);
                System.out.println("Price of " + product.getName() + " updated to " + product.getPrice());
            }
        }
	}


	/* Use case 3 */
    private void add_product() {
        Product tempProduct = new Product();
        grocery.getProductList();
        ProductList.getInstance().getProductList().add(tempProduct);
        
        
	}


	/* Use case 1 */
    private void add_member() {
		Member tempMember = new Member();
        grocery.getMemberList();
        MemberList.getInstance().getMembers().add(tempMember);
		
	}
	
	/* Use case 2 */
    private void remove_member() {
		System.out.println("Enter the ID for the member:");
		int tempId = scnr.nextInt();
		for (Member member : grocery.getMemberList().getMembers()) {
            if (member.getID() == tempId) {
                grocery.getMemberList().getMembers().remove(member);
            }
        }
	}
		
		
		



	public static void main(String[] args) {
        UserInterface.instance().process();
    }

		
		
}




