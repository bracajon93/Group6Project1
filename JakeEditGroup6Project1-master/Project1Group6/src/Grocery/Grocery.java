package Grocery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Grocery implements Serializable {

	private static Grocery grocery;
	private ProductList productList;
	private MemberList memberList;

	private Grocery() {
	}

	public MemberList getMemberList() {
		return memberList;
	}

	public ProductList getProductList() {
		return productList;
	}

	public static Grocery instance() {
		if (grocery == null) {
			return grocery = new Grocery();
		} else {
			return grocery;
		}
	}

	public static boolean save() {
		try {
			FileOutputStream file = new FileOutputStream("GroceryData");
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(grocery);
			Member.save(output);
			file.close();
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

	public static Grocery retrieve() {
		try {
			FileInputStream file = new FileInputStream("GroceryData");
			ObjectInputStream input = new ObjectInputStream(file);
			grocery = (Grocery) input.readObject();
			Member.retrieve(input);
			return grocery;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

}