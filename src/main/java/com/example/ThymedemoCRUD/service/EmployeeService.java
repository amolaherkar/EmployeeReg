package com.example.ThymedemoCRUD.service;

import java.util.List;

import com.example.ThymedemoCRUD.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp);
	
	public List<Employee> findAllByOrderByFirstNameAsc();
	
	public Employee findAllById(int empId);
	
	public void deleteEmp(int empId);
	
	

}
