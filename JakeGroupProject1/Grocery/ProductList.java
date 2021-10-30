package Grocery;

import java.util.ArrayList;

/**
 * productList
 */
public class ProductList {

    private ArrayList<Product> productArrayList;

    public ProductList() {
        productArrayList = new ArrayList<Product>();
    }
    
    public ArrayList<Product> getProducts() {
        return this.productArrayList;
    }

    

}