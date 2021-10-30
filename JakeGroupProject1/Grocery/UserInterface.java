package Grocery;

import java.util.Scanner;

/**
 * UserInterface
 */
public class UserInterface {

    Scanner scnr = new Scanner(System.in);

    private Grocery grocery; /* our variable that holds an instance of productList and memberList */

    private final int ENROLL_MEMBER = 1;
    private final int REMOVE_MEMBER = 2;
    private final int ADD_PRODUCT = 3;
    // private final int CHECK_OUT = 4;
    // private final int PROCESS_SHIPMENT = 5;
    private final int CHANGE_PRICE = 6;
    private final int GET_PRODUCT = 7;
    private final int GET_MEMBER = 8;
    // private final int PRINT_TRANSACTIONS = 9;
    // private final int LIST_OUTSTANDING_ORDERS = 10;
    private final int PRINT_MEMBERS = 11;
    private final int PRINT_PRODUCTS = 12;
    // private final int SAVE = 13;
    private final int HELP = 14;
    private final int EXIT = 0;

    /* Product Methods */
    /* Use case 3 */
    public void addProduct() {
        Product tempProduct = new Product();
        grocery.getProductList().getProducts().add(tempProduct);
    }

    public void removeProduct() {
        System.out.println("What is the id to search for?");
        int id = scnr.nextInt();

        for (Product product : grocery.getProductList().getProducts()) {
            if (product.getId() == id) {
                grocery.getProductList().getProducts().remove(product);
            }
        }
    }

    public void printProducts() { /* Prints all products */
        for (Product product : grocery.getProductList().getProducts()) {
            printProduct(product);
            System.out.println(); /* Don't delete, an extra newline to space out the products */
        }
    }

    /* Use case 7 */
    public void getProductWithString() {
        System.out.println("What is the string to search for?");
        String tempName = scnr.nextLine();

        for (Product product : grocery.getProductList().getProducts()) {
            if (product.getName().startsWith(tempName)) {
                printProduct(product);
            }
        }
    }

    private void printProduct(Product product) { /* Prints product passed as parameter */
        System.out
                .println("Product: " + product.getName() + "\nID: " + product.getId() + "\nPrice: " + product.getPrice()
                        + "\nQuantity: " + product.getQuantity() + "\nReorder level: " + product.getReorderLevel());
        System.out.println();
    }

    /* Use Case 6 */
    public void changePrice() {

        int tempID;
        System.out.println("What is the id of the product whose price you would like to change?");
        tempID = scnr.nextInt();
        for (Product product : grocery.getProductList().getProducts()) {
            if (product.getId() == tempID) {
                System.out.println("What should the new price of " + product.getName() + " be?");
                product.setPrice(scnr.nextDouble());
                System.out.println("Price of " + product.getName() + " is now " + product.getPrice());
            }
        }
    }

    /* Member Methods */
    /* Use Case 1 */
    public void addMember() {
        Member tempMember = new Member();
        grocery.getMemberList().getMembers().add(tempMember);
    }

    /* Use case 2 */
    public void removeMember() {
        int tempID;
        System.out.println("What is the id of the member you would like to remove?");
        tempID = scnr.nextInt();
        for (Member member : grocery.getMemberList().getMembers()) {
            if (member.getId() == tempID) {
                grocery.getMemberList().getMembers().remove(member);
            }
        }
    }

    /* Use Case 11 */
    public void printMembers() {
        for (Member member : grocery.getMemberList().getMembers()) {
            printMember(member);
            System.out.println();
        }
    }

    /* Use case 8 */
    public void getMemberWithString() {
        System.out.println("What is the string to search for?");
        String tempName = scnr.nextLine();

        for (Member member : grocery.getMemberList().getMembers()) {
            if (member.getName().startsWith(tempName)) {
                printMember(member);
            }
        }
    }

    public void printMember(Member member) {
        System.out.println("Member: " + member.getName() + "\nDate joined: " + member.getDateJoined() + "\nAddress: "
                + member.getAddress() + "\nPhone: " + member.getPhoneNumber() + "\nID: " + member.getId());
        System.out.println();
    }

    /**
     * Displays the help screen
     * 
     */
    public void help() {
        System.out.println("Enter a number between 0 and 12 as explained below:");
        System.out.println(EXIT + " to Exit\n");
        System.out.println(ENROLL_MEMBER + " to add a member");
        System.out.println(REMOVE_MEMBER + " to  remove a member");
        System.out.println(ADD_PRODUCT + " to  add a produc");
        // System.out.println(CHECK_OUT + " to check out");
        // System.out.println(PROCESS_SHIPMENT + " to process shipment");
        System.out.println(CHANGE_PRICE + " to change a product's price");
        System.out.println(GET_PRODUCT + " to get a product");
        System.out.println(GET_MEMBER + " to  find a member");
        // System.out.println(PRINT_TRANSACTIONS + " to print transactions");
        // System.out.println(LIST_OUTSTANDING_ORDERS + " to list outstanding orders");
        System.out.println(PRINT_MEMBERS + " to print members");
        System.out.println(PRINT_PRODUCTS + " to  print out the products");
        // System.out.println(SAVE + " to save data");
        System.out.println(HELP + " for help");
    }

    /**
     * Orchestrates the whole process. Calls the appropriate method for the
     * different functionalities.
     * 
     */
    public void process() {
        int command;
        help();
        command = scnr.nextInt();
        while ((command) != EXIT && command > 0 && command <= 14) {
            switch (command) {
            case ENROLL_MEMBER:
                addMember();
                break;
            case REMOVE_MEMBER:
                removeMember();
                break;
            case ADD_PRODUCT:
                addProduct();
                break;
            case CHANGE_PRICE:
                changePrice();
                break;
            case GET_PRODUCT:
                getProductWithString();
                break;
            case GET_MEMBER:
                getMemberWithString();
                break;
            case PRINT_MEMBERS:
                printMembers();
                break;
            case PRINT_PRODUCTS:
                printProducts();
                break;

            }
        }
    }

    /**
     * The method to start the application. Simply calls process().
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        process();
    }
}