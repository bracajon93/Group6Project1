package Grocery;

import java.util.Scanner;

/**
 * class for Product
 */
public class Product {

    private String name;
    private int id;
    private static int idCount = 999; /* keeps track of where our id is with every instance created of product */
    private String quantity;
    private String price;
    private String reorderLevel;

    /* This doesn't seem to be working right now */
    public Product(String name,  String quantity, String price, String reorderLevel) {
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
	
	public int getID() {
		return id;
	}

	public void setPrice(String updatePrice) {
		this.price = updatePrice;
		
	}

	public String getPrice() {
		return price;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getReorderLevel() {
		return reorderLevel;
	}
	
}
