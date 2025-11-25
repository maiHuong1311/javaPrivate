package serviceimpl;

import main.Main;
import model.Employee;
import service.IEmployeeService;

import java.util.List;
import java.util.ArrayList;
public class IEmployeeServiceImpl implements IEmployeeService {
    @Override
    public List<Employee> getAllEmployees() {
        return Main.employees;
    }

    @Override
    public Employee getImployeeById(String id) {
        boolean found = false;
        for(Employee employee : Main.employees) {
            if(id.equals(employee.getId())) {
                found = true;
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        List<Employee> result = new ArrayList<>();
        for(Employee employee : Main.employees) {
            if(name.equals(employee.getName())) {
                result.add(employee);
            }
        }
        return result;
    }
}
