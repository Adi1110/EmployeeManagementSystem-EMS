package com.codeOlogy.service;

import java.util.List;

import com.codeOlogy.entity.Employee;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

public interface EmployeeService {
	
	public Employee saveEmployee (Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById (int id);
	
	public boolean deleteEmployee (int id);

}
