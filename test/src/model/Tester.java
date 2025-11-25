package model;

import constant.Common;
import service.IWorkable;

public class Tester extends Employee implements IWorkable {
    private int bugDetectedCount;

    public Tester(int bugDetectedCount) {
        this.bugDetectedCount = bugDetectedCount;
    }
    public Tester(String name, int age, double basicSalary, Device device, int bugDetectedCount) {
        super(name, age, basicSalary, device);
        this.bugDetectedCount = bugDetectedCount;
    }

    public int getBugDetectedCount() {
        return bugDetectedCount;
    }
    public void setBugDetectedCount(int bugDetectedCount) {
        this.bugDetectedCount = bugDetectedCount;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Tester{" +
                "bugDetectedCount=" + bugDetectedCount +
                '}';
    }

    @Override
    public double caculateSalary() {
        return super.getBasicSalary() + super.getBASE_SALARY_RATE() * bugDetectedCount;
    }

    @Override
    public void work() {
        System.out.println(Common.WORK);
    }
}
