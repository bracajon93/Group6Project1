package Grocery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is a singleton, with an arrayList that holds all the instances of
 * Product for our co-op system
 */
public class ProductList {

    private List<Product> productList = new LinkedList<Product>();

    private static ProductList instance = null;

    private ProductList() {
    }

    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
        }
        return instance;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

}
