package service;

public interface Borrowable {
    boolean borrow(int quantity);
    int getAvailableQuantity();
}
