/**
 * 
 */
package com.codeOlogy.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.codeOlogy.entity.Employee;
import com.codeOlogy.service.EmployeeServiceImpl;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Controller
public class HomeController {

	@Autowired
	private EmployeeServiceImpl empServImpl;
	
	
	//get all the employee details
	@GetMapping("/")
	public String index(Model m) {
		List<Employee> listEmp = empServImpl.getAllEmployee();
		m.addAttribute("newList", listEmp);
		return "index";
	}
	
	
	
	//get employee form to save details
	@GetMapping("/addEmployee")
	public String employeeForm() {
		return "save_emp";
	}
	
	
	
	//create new employee
	@PostMapping("/addEmployee")
	public String addEmployee (@ModelAttribute("employee") Employee emp, HttpSession session) {
		
		Employee newEmp = empServImpl.saveEmployee(emp);
//		System.out.println(emp); // to check in console
		if(newEmp!=null) {
			session.setAttribute("msg", "Register Successfully");
		}
		else {
			session.setAttribute("msg", "Something went wrong!! Please Check with Admin");
		}
		return "redirect:/addEmployee";
	}
	
	
	
	// get employee by id to edit
	@GetMapping("/editEmp/{id}")
	public String getById(@PathVariable (value="id") int id, Model m) {
		//System.out.println(id);
		Employee empId = empServImpl.getEmployeeById(id);
		m.addAttribute("empList", empId);
		return "edit_emp";
	}
	
	
	
	//update the employee details
	@PostMapping("/updateEmployee")
	public String updateEmployeeDetails (@ModelAttribute("employee") Employee emp, HttpSession session) {
		
		Employee updtEmp = empServImpl.saveEmployee(emp);
		//System.out.println(updtEmp); // to check in console
		if(updtEmp!=null) {
			session.setAttribute("msg", "Update Successfully");
		}
		else {
			session.setAttribute("msg", "Something went wrong!! Please Check with Admin");
		}
		return "redirect:/";
	}
	
	
	//delete the employee details
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmpDetails (@PathVariable (value="id") int id, Model m, HttpSession session) {
		
		Boolean f = empServImpl.deleteEmployee(id);
		if(f) {
			session.setAttribute("msg", "Employee details with id " +id+ " Deleted Successfully");
		}
		else {
			session.setAttribute("msg", "Something went wrong!! Please Check with Admin");
		}
		return "redirect:/";
	}
}
