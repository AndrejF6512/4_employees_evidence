package com.employees.evidence.service;

import java.util.List;

import com.employees.evidence.model.Employee;

public interface EmployeeService {
	
    List<Employee> getEmployees();

    Employee getEmployee(int id);
    
    void addEmployee(Employee employee);
    
    void updateEmployee(Employee employee);
    
    void deleteEmployee(Employee employee);

}
