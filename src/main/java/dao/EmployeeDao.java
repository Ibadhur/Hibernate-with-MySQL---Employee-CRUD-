package dao;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Employee;
import util.HibernateUtil;

import java.util.List;
public class EmployeeDao implements InterEmployeeDao {

    // save Employee
    // get All Employee
    // get Employee By empId
    // Update Employee
    // Delete Employee

    @Override
    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.persist(employee);

            // commit the transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.merge(employee);

            // commit the transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public Employee getEmployeeByEmpId(long empId) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get employee object
            employee = session.get(Employee.class, empId);

            // commit the transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Transaction transaction = null;
        List < Employee > employees = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            // get employee
            CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
            criteriaQuery.from(Employee.class);

            employees = session.createQuery(criteriaQuery).getResultList();

            // commit the transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employees;
    }

    @Override
    public void deleteEmployee(long empId) {
        Transaction transaction = null;
        Employee employee = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // delete Employee object
            employee = session.get(Employee.class, empId);
            session.remove(employee);

            // commit the transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
