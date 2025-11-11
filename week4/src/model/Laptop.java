package model;

public class Laptop extends Product {
    private String ram;
    private String cpu;

    public Laptop() {}
    public Laptop(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }
    public Laptop(String name, String description, double price, String ram, String cpu) {
        super(name, description, price);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public String getInfo() {
        return "---LAPTOP---\n" +
                super.getInfo() +
                "Ram: " + this.ram + "\n" +
                "CPU: " + this.cpu +"\n";
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Laptop{" +
                "ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}