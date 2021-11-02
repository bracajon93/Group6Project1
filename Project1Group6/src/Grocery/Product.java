package Grocery;

import java.util.Scanner;

/**
 * class for Product
 */
public class Product {

    private String name;
    private int id;
    private static int idCount = 0; /* keeps track of where our id is with every instance created of product */
    private int quantity;
    private String price;
    private int reorderLevel;

    public Product(String name,  int quantity, String price, int reorderLevel) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int newQuantity){
		this.quantity = newQuantity;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}
	
}
