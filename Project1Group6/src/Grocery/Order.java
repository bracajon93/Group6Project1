package Grocery;

import java.util.ArrayList;

public class Order {
    private int orderID;
    private static int idCount = 0;
    private int quantityOrder;
	private int productID;
	private String orderString;
    
	public Order(int productID, int reorderLevel) {
		this.productID = productID;
		this.quantityOrder  = reorderLevel * 2;
		this.orderID = idCount;
		idCount++;
		
	}
	
	public int getQuantityOrder() {
		return quantityOrder;
	}

	public int getProductID() {
		return productID;
	}
	
	public String toString() {
		String orderString = "Order ID: ";
		orderString+= Integer.toString(orderID);
		orderString+= " Product ID: ";
		orderString+= Integer.toString(productID);
		orderString+= " Quantity : ";
		orderString+= Integer.toString(quantityOrder);
		return orderString;
	}

}
