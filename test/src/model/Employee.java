package model;

import java.util.UUID;

public abstract class Employee {
    private String id;
    private String name;
    private int age;
    private double basicSalary;
    private Device device;
    private static int employeeCount = 0;
    private final double BASE_SALARY_RATE = 500000;

    public Employee() {
        employeeCount++;
    }
    public Employee(String name, int age, double basicSalary, Device device) {
        employeeCount++;
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Device getDevice() {
        return device;
    }
    public void setDevice(Device device) {
        this.device = device;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public double getBASE_SALARY_RATE() {
        return BASE_SALARY_RATE;
    }

    abstract double caculateSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", basicSalary=" + basicSalary +
                ", device=" + device;
    }
}
