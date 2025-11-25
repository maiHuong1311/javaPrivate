package main;

import constant.Common;
import constant.ErrorMessage;
import model.Developer;
import model.Device;
import model.Employee;
import model.Tester;
import serviceimpl.IEmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        IEmployeeServiceImpl e = new IEmployeeServiceImpl();
        Scanner sc = new Scanner(System.in);
        employees.add(new Developer("Minh", 22, 10000000, new Device("laptop"),8));
        employees.add(new Tester("Linh", 25, 12000000, new Device("laptop"),9));
        employees.add(new Developer("Hoàng", 24, 15000000, new Device("laptop"),3));
        employees.add(new Tester("Lan", 21, 9000000, new Device("laptop"),10));
        employees.add(new Developer("Tâm", 23, 13000000, new Device("laptop"),6));
        System.out.print(Common.MENU);
        while(true) {
            int choice;
            System.out.print(Common.ENTER_CHOICE);
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    if(employees.isEmpty())
                        System.out.println(ErrorMessage.LIST_IS_EMTPY);
                    else {
                        System.out.println(Common.INFO_EMPLOYEE);
                        for(Employee employee : employees) {
                            System.out.println(employee.toString());
                        }
                    }
                    break;
                case 2:
                    System.out.print(Common.ENTER_ID);
                    String id = sc.nextLine();
                    if(e.getImployeeById(id) == null)
                        System.out.println(ErrorMessage.NOT_FOUND);
                    else {
                        System.out.println(Common.INFO_EMPLOYEE);
                        System.out.println(e.getImployeeById(id).toString());
                    }
                    break;
                case 3:
                    System.out.print(Common.ENTER_NAME);
                    String name = sc.nextLine();
                    if(e.getEmployeeByName(name).isEmpty())
                        System.out.println(ErrorMessage.LIST_IS_EMTPY);
                    else {
                        System.out.println(Common.INFO_EMPLOYEE);
                        List<Employee> result = e.getEmployeeByName(name);
                        for(Employee employee : result)
                            System.out.println(employee.toString());
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println(ErrorMessage.INVALID_CHOICE);
                    break;
            }
        }
    }
}