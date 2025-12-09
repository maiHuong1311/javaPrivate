package model;

import constant.Common;
import service.IDebuggable;

public class Developer extends Employee implements IDebuggable {
    private int overtimeHours;

    public Developer(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
    public Developer(String name, int age, double basicSalary, Device device, int overtimeHours) {
        super(name, age, basicSalary, device);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }
    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Developer{" +
                "overtimeHours=" + overtimeHours +
                "}}";
    }

    @Override
    public double caculateSalary() {
        return super.getBasicSalary() + super.getBASE_SALARY_RATE() * overtimeHours;
    }

    @Override
    public void fixBug() {
        System.out.println(Common.FIX_BUG);
    }
}
