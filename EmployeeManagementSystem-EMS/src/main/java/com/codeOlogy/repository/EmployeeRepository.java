package com.codeOlogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeOlogy.entity.Employee;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
