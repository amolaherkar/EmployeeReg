package com.example.ThymedemoCRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ThymedemoCRUD.dao.EmployeeRepository;
import com.example.ThymedemoCRUD.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	

	@Override
	public List<Employee> findAllByOrderByFirstNameAsc() {
		
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}


	@Override
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);	
	}


	@Override
	public Employee findAllById(int empId) {
		
		List<Employee> emp=new ArrayList<Employee>();
Optional<Employee> result = employeeRepository.findById(empId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + empId);
		}
		
		return theEmployee;

	}


	@Override
	public void deleteEmp(int empId) {
	
		employeeRepository.deleteById(empId);
		
	}
}
