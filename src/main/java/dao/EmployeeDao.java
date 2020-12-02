package dao;

import java.util.List;

import model.entities.Employee;

public interface EmployeeDao {
    void create(  Employee  employee );
    Employee find( int id );
    List<Employee> findAll();
    void update(Employee employee);
    void delete (int id);
}
