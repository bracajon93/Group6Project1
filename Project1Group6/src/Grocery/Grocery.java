package Grocery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;


public class Grocery implements Serializable{
	
	private static Grocery grocery;
	
	private Grocery() {
    }
	
	public static Grocery instance() {
        if (grocery == null) {
            return grocery = new Grocery();
        } else {
            return grocery;
        }
    }
	public static Member addMember(String name, String address, long phoneNumber,
			Calendar dateJoined, Double feePaid) {
		Member member = new Member(name, address, phoneNumber, dateJoined,
				feePaid);
		if(MemberList.insertMember(member)) {
			return (member);
		}
		return null;
	}
	
	public static String removeMember(int searchMemberID) {
			Member member = MemberList.retrieveMember(searchMemberID);
			if (member!= null) {
				MemberList.removeMember(member);
				return("Member Removed Successfully!");
		}else {
			return("Member Not Found.");
		}
	}
	
	public static Product addProduct(String name,  int quantity, double price, int reorderLevel){
		Product product = new Product(name, quantity, price, reorderLevel);
		if(ProductList.insertProduct(product)) {
			return(product);
		}
		return null;
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