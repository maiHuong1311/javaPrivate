package model;

import java.util.Random;

public class Product {
    private int id;
    private  String name;
    private String description;
    private double price;

    public Product() {}
    public Product(String name, String description, double price) {
        this.id = new Random().nextInt(1000);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Product getById(int id) {
        if(this.id == id)
            return this;
        return null;
    }

    public String getInfo() {
        return  "Id: " + this.id + "\n" +
                "Name: " + this.name + "\n" +
                "Description: " + this.description + "\n" +
                "Price: " + String.format("%,.0f", this.price) + "\n";
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
