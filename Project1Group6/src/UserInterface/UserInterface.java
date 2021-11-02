package UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import CollectionClasses.MemberList;
import CollectionClasses.ProductList;
import Grocery.Grocery;
import Grocery.Member;
import Grocery.Order;
import Grocery.Product;
import Grocery.Transaction;

import java.io.BufferedReader;

public class UserInterface {
    private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Grocery grocery;
    Scanner scnr = new Scanner(System.in);
    private String prompt;
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
    
    
    //to ask member to automatically generate a test bed or not
    //retrieve 'exisiting' saved file
    private UserInterface() {
        if (yesOrNo("Look for saved data and  use it?")) {
            retrieve();
        } else {
            grocery = Grocery.instance();
        }

    }

    //creates an instance of our UI
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }

    //to read in strings throughout program
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
    
    //menu print out
    public void help() {
        System.out.println("Enter a number between 0 and 12 as explained below:");
        System.out.println(EXIT + " to Exit\n");
        System.out.println(ADD_MEMBER + " to add a member");
        System.out.println(REMOVE_MEMBER + " to  remove a member");
        System.out.println(ADD_PRODUCT + " to  add a product");
        System.out.println(CHECK_OUT + " to  check out members' items ");
        System.out.println(PROCESS_SHIPMENT + " to process a shipment ");
        System.out.println(CHANGE_PRICE + " to  change the price of a product");
        System.out.println(PRODUCT_INFO + " to search for a product");
        System.out.println(MEMBER_INFO + " to  search for a member");
        System.out.println(PRINT_TRANSACTIONS + " to print members transactions give to date inputs");
        System.out.println(OUTSTANDING_ORDERS + " to  display any outstanding orders");
        System.out.println(SHOW_MEMBERS + " to list all the members");
        System.out.println(SHOW_PRODUCTS + " to list all the products");
        System.out.println(SAVE + " to  save data");
        System.out.println(HELP + " for help");
    }
    
    //switch menu 
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
            	//process_shipment();
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
    
 // case 1
    private void add_member() {
        Member result;
        String name = getToken("Enter members name: ");
        String address = getToken("Enter the address of the new member: ");
        String phoneNumber = getToken("Enter the phone number of the new member: ");
        Calendar dateJoined = getDate("Enter the date joined of the new member: ");
        String feePaid = getToken("Enter the fee paid for the new member:");
        result = Grocery.addMember(name, address, phoneNumber, dateJoined, feePaid);
        System.out.println("New member " + result.getName() + " added successfully.");
        System.out.println("Member ID is " + result.getID());

    }
    
    // case 2
    private void remove_member() {
        System.out.println("Enter the Member ID to be remove:");
        int searchMemberID = scnr.nextInt();
        String result = Grocery.removeMember(searchMemberID);
        System.out.println(result);
    }
    
    // case 3
    private void add_product() {
        String name = getToken("Enter the name of the product:");
        int quantity = getNumber("Enter the quantity (int) of the product:");
        String price = getToken("Enter the price (can be a floating point number) of the product:");
        int reorderLevel = getNumber(
                "Enter the minimum quantity for the product before it is automatically reordered:");
        Product result = Grocery.addProduct(name, quantity, price, reorderLevel);
        System.out.println("New product " + result.getName() + " added successfully.");

    }
    
    //use case 4    
    private void check_out() {
    	int memberID = -1;
    	double grandTotal = 0;
    	String transactionInvoice = "";
    	Calendar date = getDate("Enter transaction date: ");
    	//try method to verify member ID is valid
    	try {
    	int searchMemberID = getNumber("Enter Member's ID: ");
    	String result = Grocery.verifyMemberID(searchMemberID);
    	memberID = searchMemberID;
    	System.out.println(result);
    	}catch(Exception e) {
    		System.out.println("Member ID invalid");
    	}
    	int numberOfProducts = getNumber("Enter number of products to check out: ");
    	ArrayList<Order> orders = null;
    	for(int i=0; i < numberOfProducts; i++) {
    		double total;
    		boolean valid = true;
    		int productID = 0;
    		int quantityCheckingOut = 0;
    		Product product = null;
    		while(valid) {
    		try {
    		int searchProductID = getNumber("Enter product ID: ");
    		String result = Grocery.verifyProductID(searchProductID);
    		product = Grocery.getProduct(searchProductID);
    		System.out.println(result);
    		productID = searchProductID;
    		try {
    			int verifyQuantity = getNumber("Enter quantity: ");
    			String result2 = Grocery.verifyQuantity(productID, verifyQuantity);
    			Order result3 = Grocery.checkReorderLevel(productID, verifyQuantity);
    			orders.add(result3);
    			System.out.println(result2);
    			quantityCheckingOut = verifyQuantity;
    			total = Grocery.getTotal(productID, quantityCheckingOut);
        		grandTotal+= total;
        		DecimalFormat twoDForm = new DecimalFormat("#.##");
        		Double.valueOf(twoDForm.format(grandTotal));
        		String itemResultString = " ";
        		itemResultString = product.getName() + " " + Integer.toString(quantityCheckingOut) + " " + 
        				(twoDForm.format(total) + " " + twoDForm.format(grandTotal));
        		System.out.println(itemResultString);
        		transactionInvoice += itemResultString;
        		Transaction result4 = Grocery.createTransaction(date, transactionInvoice, memberID);
        		valid = false;
    		}catch(Exception e) {
    			System.out.println("Quantity entered unavailable.");
    			valid = false;
    		}
    		
    		}catch (Exception e){
    			System.out.println("Product ID invalid: ");
    			valid = false;
    		}
    		}
    		Transaction result4 = Grocery.createTransaction(date, transactionInvoice, memberID);
    		
    	}
    	
    	
    }
    
    /*use case 5
    private void process_shipment() {
    	
    	
	}
	*/
    
    //use case 6
    private void change_price() {
        System.out.println("Enter the ID of the product :");
        int searchProductID = scnr.nextInt();
        boolean result = Grocery.searchItem(searchProductID);
        if (result) {
            String newPrice = getToken("Enter new price: ");
            Product product = ProductList.updatePrice(searchProductID, newPrice);
            System.out.println("Product " + product.getName() + " price updated to: " + product.getPrice());

        } else {
            System.out.println("Item not found.");
        }
    }
    
  //use case 7
    private void product_info() {
        System.out.println("What should we be searching for?");
        String tempString = scnr.nextLine();
        grocery.getProductList();
        for (Product product : ProductList.getInstance().getProductList()) {
            if (product.getName().startsWith(tempString)) {
                System.out.println("Product: " + product.getName() + "\nID: " + product.getID() + "\nQuantity: "
                        + product.getQuantity() + "\nPrice: " + product.getPrice() + "\nReorder level: "
                        + product.getReorderLevel());
                System.out.println();
            }
        }
    }
    
    //use case 8
    private void member_info() {
        String searchMemberString = getToken("Search for : ");
        grocery.getMemberList();
        grocery.member_info(searchMemberString);

    }
    
    //use case 9
    private void print_transactions() {
    	try {
    	int searchMemberID = getNumber("Enter Member's ID: ");
    	String result = Grocery.verifyMemberID(searchMemberID);
    	System.out.println(result);
    	Calendar date1 = getDate("Enter first date: ");
    	Calendar date2 = getDate("Enter second date: ");
    	int comparison = date1.compareTo(date2);
    	if (comparison <= 0) {
			grocery.showTransactions(searchMemberID, date1, date2);
    	}else {
    		System.out.println("First date is invalid, occurs after 2nd date.");
    	}
    	}catch(Exception e) {
    		System.out.println("Member ID invalid");
    	}
    }
    
    //use case 10
    private void outstanding_orders() {
    	grocery.outstandingOrders();
    }
    
    //use case 11
    private void show_members() {
        grocery.showMembers();
    }
    
    //use case 12
  	private void show_products() {
          grocery.getProductList();
          for (Product product : ProductList.getInstance().getProductList()) {
              System.out.println("Product: " + product.getName() + "\nID: " + product.getID() + "\nQuantity: "
                      + product.getQuantity() + "\nPrice: " + product.getPrice() + "\nReorder level: "
                      + product.getReorderLevel());
              System.out.println(); /* don't delete */
          }
      }

    public static void main(String[] args) {
        UserInterface.instance().process();
    }

}
