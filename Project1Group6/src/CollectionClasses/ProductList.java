package CollectionClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Grocery.Product;
/**
 * This class is a singleton, with an arrayList that holds all the instances of
 * Product for our co-op system
 */
public class ProductList {

	private static List<Product> productList = new LinkedList<Product>();
	
	private static ProductList instance = null;

	private ProductList() {
	}

	public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
        }
        return instance;
    }

	public static boolean insertProduct(Product product) {
		productList.add(product);
		return true;
	}
	
	public static Product retrieveProduct(int searchProductID) {
		for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
            Product product = iterator.next();
            if (product.getID() == (searchProductID)) {
                return product;
            }
        }
        return null;
	}

	public static Product updatePrice(int searchProductID, String updatePrice) {
		for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
            Product product = iterator.next();
            if (product.getID() == (searchProductID)) {
                product.setPrice(updatePrice);
                return  product;
            }
		}
		return null;
	}

	public static void updatePrice(int searchProductID) {
		
	}
	
	public List<Product> getProductList() {
        return ProductList.productList;
    }
}




