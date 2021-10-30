package Grocery;

import java.util.Scanner;

/**
 * class for Product
 */
public class Product {

    private String name;
    private int id;
    private static int idCount = 999; /* keeps track of where our id is with every instance created of product */
    private int quantity;
    private double price;
    private int reorderLevel;

    /* This doesn't seem to be working right now */
    public Product(String name,  int quantity, double price, int reorderLevel) {
        this.name = name;
        
        this.quantity = quantity;
        this.price = price;
        this.id = idCount;
        idCount++;
        this.reorderLevel = reorderLevel;
        
    }

	public String getName() {
		return name;
	}
}
