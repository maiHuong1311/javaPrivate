package service;

import constant.Common;
import constant.ErrorMessage;
import constant.SuccessfulMessage;
import model.Laptop;
import model.Product;
import model.SmartPhone;

import java.util.ArrayList;

public class ProductController {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductController() {}
    public ProductController(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(SuccessfulMessage.SUCCESS_ADD);
    }
    public void addProduct(String type, String name, String description, double price) {
        if(type.equalsIgnoreCase(Common.PRODUCT_LAPTOP_TYPE)) {
            Laptop laptop = new Laptop(name, description, price, Common.DEFAULT_LAPTOP_RAM, Common.DEFAULT_LAPTOP_CPU);
            products.add(laptop);
            System.out.println(SuccessfulMessage.SUCCESS_ADD);
        }
        else if(type.equalsIgnoreCase(Common.PRODUCT_SMARTPHONE_TYPE)) {
            SmartPhone smartphone = new SmartPhone(name, description, price, true);
            products.add(smartphone);
            System.out.println(SuccessfulMessage.SUCCESS_ADD);
        }
        else
            System.out.println(ErrorMessage.ERROR_INVALID_TYPE);
    }
    public void removeById(int id) {
        boolean found = false;
        for(Product x : products) {
            if(x.getId() == id) {
                products.remove(x);
                System.out.println(SuccessfulMessage.SUCCESS_REMOVE);
                found = true;
                break;
            }
            if(!found)
                System.out.println(ErrorMessage.ERROR_NOT_FOUND);
        }
    }
    public Product getById(int id) {
        for(Product x : products) {
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }
    public ArrayList<Product> getAllProducts() {
        return products;
    }
}
