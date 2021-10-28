package Grocery;

import java.util.Scanner;

/**
 * class for Product
 */
public class Product {

    Scanner scnr = new Scanner(System.in);

    private String name;
    private int id;
    private static int idCount = 0; /* keeps track of where our id is with every instance created of product */
    private int quantity;
    private double price;
    private int reorderLevel;

    public Product() {

        System.out.println("Enter the name of the product:");
        this.name = scnr.nextLine();

        this.id = idCount;
        idCount++;

        System.out.println("Enter the quantity (int) of the product:");
        this.quantity = scnr.nextInt();

        System.out.println("Enter the price (can be a floating point number) of the product:");
        this.price = scnr.nextDouble();

        System.out.println("Enter the minimum quantity for the product before it is automatically reordered:");
        this.reorderLevel = scnr.nextInt();

        /*
         * TO-DO: Order 2x the reorderLevel at the creation of each product
         */

    }

    /* This doesn't seem to be working right now */
    public Product(String name,  int quantity, double price, int reorderLevel) {
        this.name = name;
        
        this.quantity = quantity;
        this.price = price;
        this.id = idCount;
        idCount++;
        this.reorderLevel = reorderLevel; /*
                                           * TO-DO: Order 2x the reorderLevel at the creation of each product
                                           */
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getReorderLevel() {
        return this.reorderLevel;
    }
}
