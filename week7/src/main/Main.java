package main;

import model.Car;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car("Ferrari", 500);
        Car c2 = new Car("Lamborghini", 600);
        Car c3 = new Car("Porsche", 550);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
    }
}