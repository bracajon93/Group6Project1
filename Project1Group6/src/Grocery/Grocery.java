package Grocery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import CollectionClasses.MemberList;
import CollectionClasses.OrderList;
import CollectionClasses.ProductList;
import CollectionClasses.TransactionList;


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
	
	public static Product addProduct(String name,  int quantity, String price, int reorderLevel){
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

	public static String verifyMemberID(int memberID) throws Exception {
		Member member = MemberList.retrieveMember(memberID);
		if (member!= null) {
			return("Member Found!");
		}throw new Exception();
	}

	public static String verifyProductID(int searchProductID) throws Exception {
		Product product = ProductList.retrieveProduct(searchProductID);
		if(product!=null) {
			return("Product Found!");
		}throw new Exception();
	}

	public static String verifyQuantity(int productID, int verifyQuantity) throws Exception {
		ArrayList<Order> orders = new ArrayList<Order>();
		Product tempProduct = ProductList.retrieveProduct(productID);
		if (tempProduct.getQuantity() >= verifyQuantity) {
			tempProduct.setQuantity(tempProduct.getQuantity()-verifyQuantity);
			return("Quantity valid.");
		}throw new Exception();
	}

	public static double getTotal(int productID, int quantityCheckingOut) {
		Product product = ProductList.retrieveProduct(productID);
		double total = Double.valueOf(product.getPrice()) * quantityCheckingOut;
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		Double.valueOf(twoDForm.format(total));
		return total;
	}

	public static Product getProduct(int searchProductID) {
		Product product = ProductList.retrieveProduct(searchProductID);
		return product;
	}
	
	public static Transaction createTransaction(Calendar date, String transactionDetails, int memberID) {
		Transaction transaction = new Transaction(date, transactionDetails, memberID);
		if(TransactionList.insertTransaction(transaction)) {
			return (transaction);
		}
		return null;
		
	}

	public void showMembers() {
		for (Member member : MemberList.getInstance().getMembers()) {
            System.out.println("Name: " + member.getName() + "\nDate joined: " + member.getDate()
                    + "\nAddress: " + member.address + "\nPhone number: " + member.phoneNumber);
        }
		
	}

	public void showTransactions(int searchMemberID, Calendar date1, Calendar date2) {
		for (Transaction transaction : TransactionList.getInstance().getTransactions()) {
			if (transaction.getID() == searchMemberID) {
				Calendar transactionDate = transaction.getDate();
				int dateComparison1 = transactionDate.compareTo(date1);
				int dateComparison2 = transactionDate.compareTo(date2);
				if((dateComparison1 >= 0) && (dateComparison2 <= 0)) {
					System.out.println(transaction.toString());
			}else {
				System.out.println("");
			}
		}
	}
	}

	public static Order checkReorderLevel(int productID, int verifyQuantity) {
		/*Check if a reorder of product needs to be made
		 */
		Product tempProduct = ProductList.retrieveProduct(productID);
		if (tempProduct.getQuantity() >= verifyQuantity) {
			if(tempProduct.getQuantity() <= tempProduct.getReorderLevel()) {
			Order order = new Order(productID, tempProduct.getReorderLevel());
			System.out.println(tempProduct.getName()+ " reordered for " + Integer.toString(tempProduct.getReorderLevel()*2));
			return order;
		}else {
			System.out.println("Reorder not needed");
		}
	}
		return null;
	}

	public void outstandingOrders() {
		for (Order order : OrderList.getInstance().getOrders()) {
			System.out.println(order.toString());
		}
	}

	public void member_info(String searchMemberString) {
		for (Member member : MemberList.getInstance().getMembers()) {
			if (member.getName().startsWith(searchMemberString)) {
                System.out.println("Name: " + member.getName() + "\nDate joined: " + member.dateJoined.toString()
                        + "\nAddress: " + member.address + "\nPhone number: " + member.phoneNumber);
            }
        }
	}


}