package com.example.ThymedemoCRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ThymedemoCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
public List<Employee> findAllByOrderByFirstNameAsc();
}
