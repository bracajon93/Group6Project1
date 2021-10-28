package Grocery;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is a singleton, with an arrayList that holds all the instances of
 * Product for our co-op system
 */
public class productList {

    Scanner scnr = new Scanner(System.in);

    private static productList instance = null;

    private ArrayList<Product> listOfProducts = new ArrayList<Product>();

    private productList() {

    }

    public static productList getInstance() {
        if (instance == null) {
            instance = new productList();
        }
        return instance;
    }

    public void addProduct() {
        Product tempProduct = new Product();
        instance.listOfProducts.add(tempProduct);
    }

    public void addProduct(String name,  int quantity, double price, int reorderLevel) {
        Product tempProduct = new Product(name, quantity, price, reorderLevel);
        instance.listOfProducts.add(tempProduct);
    }

    public ArrayList<Product> getListOfProducts() {
        return instance.listOfProducts;
    }

    public void searchProducts(String name) {
        productList temp = productList.getInstance();
        System.out.println("Searching for: " + name);
        for (Product product : temp.getListOfProducts()) {
            if (product.getName().startsWith(name)) {
                System.out.println(
                        String.format("%s, ID: %d, Quantity: %d, Price: %.2f, Reorder level: %d", product.getName(),
                                product.getId(), product.getQuantity(), product.getPrice(), product.getReorderLevel()));
            }

        }
    }

    /* Given an id, change the price of the product with this id. then print the name of product and 
    its new price */
    public void changePriceUsingId(int id) {
        productList temp = productList.getInstance();
        for (Product product : temp.getListOfProducts()) {
            if (product.getId() == id) {
                System.out.println("The product whose price you are changing is " + product.getName() + ". What should its new price be: ");
                double tempPrice = scnr.nextDouble();
                product.setPrice(tempPrice); 
                System.out.println("Product: " + product.getName() + ", $" + product.getPrice());
            }
        }
    }


}
