package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getImployeeById(String id);
    List<Employee> getEmployeeByName(String name);
}
