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
	public static Member addMember(String name, String address, String phoneNumber,
			Calendar dateJoined, String feePaid) {
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
	
	public static Product addProduct(String name,  String quantity, String price, String reorderLevel){
		Product product = new Product(name, quantity, price, reorderLevel);
		if(ProductList.insertProduct(product)) {
			return(product);
		}
		return null;
	}
	
	public static Member searchMember(String searchMemberString) {
		Member member = MemberList.retrieveMember(searchMemberString);
		if (member!= null) {
			return member;
		}else {
			return(null);
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

	public static String changePrice(Product product) {
		return null;
	}

	public static boolean searchItem(int searchProductID) {
		Product product = ProductList.retrieveProduct(searchProductID);
		if (product!= null) {
			return(true);
	}else {
		return(false);
	}
	}


}