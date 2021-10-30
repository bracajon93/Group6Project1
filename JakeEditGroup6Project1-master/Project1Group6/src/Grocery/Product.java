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
    private String quantity;
    private String price;
    private String reorderLevel;

    

    public  Product() {

        System.out.println("Enter a name for the new product:");
        this.name = scnr.nextLine();

        this.id = idCount;
        idCount++;

        System.out.println("Enter the quantity for the new product:");
        this.setQuantity(scnr.nextLine());

        System.out.println("Enter the price for the new product:");
        this.price = scnr.nextLine();

        System.out.println("Enter the reorder level for the new product:");
        this.setReorderLevel(scnr.nextLine());
    }

	public String getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(String reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
}
