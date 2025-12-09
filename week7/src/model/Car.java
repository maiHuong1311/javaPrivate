package model;

import exception.BrokenCarException;

import java.util.Random;

public class Car implements Runnable {
    Random random = new Random();
    private String name;
    private double speed;

    public Car() {}
    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void run() {
        try {
            for(int i = 1; i <= 30; i++) {
                if(random.nextDouble() < 0.1)
                    throw new BrokenCarException("Xe " + name + " bị nổ lốp!");
                double delay = 100 + random.nextDouble(speed - 100);
                Thread.sleep((long) delay);
                System.out.println("[" + name + "]: Đã chạy được " + i + " km");
            }
            System.out.println(name + " đã hoàn thành cuộc đua!");
        }
        catch (BrokenCarException e) {
            System.out.println(e.getMessage());
        }
        catch (InterruptedException e) {
            System.out.println("Luồng bị gián đoạn!");
        }
    }
}
