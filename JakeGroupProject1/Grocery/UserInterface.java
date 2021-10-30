package Grocery;

import java.util.Scanner;

/**
 * UserInterface
 */
public class UserInterface {

    Scanner scnr = new Scanner(System.in);

    private Grocery grocery; /* our variable that holds an instance of productList and memberList */

    /* Product Methods */
    /* Use case 3 */
    public void addProduct() {
        Product tempProduct = new Product();
        grocery.getProductList().getProducts().add(tempProduct);
    }

    public void removeProduct(int id) {
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
    public void getProductWithString(String tempName) {
        for (Product product : grocery.getProductList().getProducts()) {
            if (product.getName().startsWith(tempName)) {
                printProduct(product);
            }
        }
    }

    private void printProduct(Product product) { /* Prints product passed as parameter */
        System.out.println("Product: " + product.getName() + "\nID: " + product.getId() + "\nPrice: " + product.getPrice() + "\nQuantity: " + product.getQuantity() + "\nReorder level: " + product.getReorderLevel());
        System.out.println();
    }

    /* Use Case 6 */
    public void changePrice(int id) {

        for (Product product : grocery.getProductList().getProducts()) {
            if (product.getId() == id) {
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
    public void removeMember(int id) {
        for (Member member : grocery.getMemberList().getMembers()) {
            if (member.getId() == id) {
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
    public void getMemberWithString(String tempName) {
        for (Member member : grocery.getMemberList().getMembers()) {
            if (member.getName().startsWith(tempName)) {
                printMember(member);
            }
        }
    }

    public void printMember(Member member){
        System.out.println("Member: " + member.getName() + "\nDate joined: " + member.getDateJoined() + "\nAddress: "+ member.getAddress() + "\nPhone: " + member.getPhoneNumber() + "\nID: " + member.getId());
        System.out.println();
    }
}