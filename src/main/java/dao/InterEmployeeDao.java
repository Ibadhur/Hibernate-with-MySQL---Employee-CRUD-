package dao;

import java.util.List;

import model.Employee;

public interface InterEmployeeDao {
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Employee getEmployeeByEmpId(long empId);
    List<Employee> getAllEmployee();
    void deleteEmployee(long empId);
}
