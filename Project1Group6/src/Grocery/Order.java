package Grocery;

public class Order {
    private int id;
    private static int idCount = 0;
    public Order(){
        id = idCount;
        idCount++;
    }
}
