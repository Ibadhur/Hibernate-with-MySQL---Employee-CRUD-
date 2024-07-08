package Main;

import java.util.List;
import dao.InterEmployeeDao;
import dao.EmployeeDao;
import model.Employee;

public class App {
    /** * @param args */

    public static void main(String[] args) {
        InterEmployeeDao employeeDao = new EmployeeDao();

        // test save Employee
        Employee employee = new Employee("Ibadhur", "Rahman", "s92065452@ousl.lk");
        employeeDao.saveEmployee(employee);

        // test update Employee
        employee.setFirstName("Abdhul");
        employeeDao.updateEmployee(employee);

        // test getEmployeeByempId
        Employee employee1 = employeeDao.getEmployeeByEmpId(employee.getId());

        // test get All Employees
        List < Employee > employees = employeeDao.getAllEmployee();
        employees.forEach(employee2 -> System.out.println(employee2.getId()));

        // test delete Employee
        employeeDao.deleteEmployee(employee.getId());
    }
}
