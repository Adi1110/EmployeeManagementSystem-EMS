package com.codeOlogy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.codeOlogy.entity.Employee;
import com.codeOlogy.repository.EmployeeRepository;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee newEmployee = empRepo.save(emp);
		return newEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee emp = empRepo.findById(id).get();
		if(emp != null ) {
			empRepo.delete(emp);
			return true;
		}
		return false;
	}

	
	public void removeSessionMessage() {
		
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
				.getRequest().getSession();
		session.removeAttribute("msg");
	}
}
