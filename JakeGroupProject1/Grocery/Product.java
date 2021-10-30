package Grocery;

import java.util.Scanner;

/**
 * Product
 */
public class Product {

    Scanner scnr = new Scanner(System.in);

    private String name;
    private int id;
    private int quantity;
    private double price;
    private int reorderLevel;

    public Product(String name, int id, int quantity, double price, int reorderLevel) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.reorderLevel = reorderLevel;
        /* to-do: immediately create an order for 2x the reorder level */
    }

    public  Product() {

        System.out.println("Enter a name for the new product:");
        this.name = scnr.nextLine();

        System.out.println("Enter an id for the new product:");
        this.id = scnr.nextInt();

        System.out.println("Enter the quantity for the new product:");
        this.quantity = scnr.nextInt();

        System.out.println("Enter the price for the new product:");
        this.price = scnr.nextInt();

        System.out.println("Enter the reorder level for the new product:");
        this.reorderLevel = scnr.nextInt();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public int getReorderLevel() {
        return this.reorderLevel;
    }

    public void setPrice(double price){
        this.price = price;
    }
}