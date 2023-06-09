package com.employees.evidence.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.employees.evidence.model.Employee;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {
	
    //private final Map<Integer, Employee> employees;
    private final List<Employee> employeesList;
    
    private static int i = 0;
    
    public static int incrementId() {
    	return i++;
    }
    
    public EmployeeServiceImpl() {

    	List<Employee> employeeList = new ArrayList<>();
    	employeeList.add(new Employee(incrementId(), "Andrej", "Foltán", "foltan@gmail.com"));
    	employeeList.add(new Employee(incrementId(), "Kamil", "Korec", "korec@gmail.com"));
    	employeeList.add(new Employee(incrementId(), "Igor", "Tronec","tronec@gmail.com"));
    	
    	this.employeesList = employeeList;
    }
	
	public List<Employee> getEmployees() {
		return employeesList;
	}

	public Employee getEmployee(int id) {
		for(Employee em : employeesList) {
			if(em.getId() == id) {
				return em;
			}
		}
		return null;
	}
	
	public void addEmployee(Employee employee) {
		employee.setId(incrementId());
		employeesList.add(employee);
	}
	
	public void updateEmployee(Employee employee) {
		Employee currentEmployee = getEmployee(employee.getId());
		currentEmployee.setEmail(employee.getEmail());
		currentEmployee.setFirstName(employee.getFirstName());
		currentEmployee.setLastName(employee.getLastName());
	}
	
	
	public void deleteEmployee(Employee employee) {
		
		Iterator<Employee> ite = employeesList.iterator();
		
		while (ite.hasNext()){
			Employee emp = (Employee) ite.next();
			if(employee.getId() == emp.getId()) {
				ite.remove();
			}
		}

	}

}
