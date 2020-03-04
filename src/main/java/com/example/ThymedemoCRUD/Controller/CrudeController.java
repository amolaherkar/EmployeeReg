package com.example.ThymedemoCRUD.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ThymedemoCRUD.entity.Employee;
import com.example.ThymedemoCRUD.entity.Employee;
import com.example.ThymedemoCRUD.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class CrudeController {
	
	EmployeeService emplyoyeeService;
	
	 public CrudeController(EmployeeService theemplyoyeeService) {
		 emplyoyeeService=theemplyoyeeService;
	}
	
@RequestMapping("/hello")
public String hello(Model model) {
	
	model.addAttribute("hello","Hello");

	List<Employee> li1=new ArrayList<>();
	
	li1=emplyoyeeService.findAllByOrderByFirstNameAsc();
	model.addAttribute("list", li1);
	
	return "employee/helloHtml";
}

@RequestMapping("/showFormAdd")
public String showFormForAdd(Model model) {
	Employee emp=new Employee();
	
	model.addAttribute("employee",emp);

	return "employee/empAddForm";
}
@PostMapping("/saveEmplyee")
public String saveEmployeeMethod(@ModelAttribute("employee")Employee theEmployee) {
	
	System.out.println("In the show form method");
	emplyoyeeService.addEmployee(theEmployee);
	
	return "redirect:/employee/hello";
}
@GetMapping("/showFormUpdate")
public String showFormUpdate(@ModelAttribute("employeeId")int theId, Model model) {
	
	Employee emp=emplyoyeeService.findAllById(theId);
	
    model.addAttribute("employee",emp);
	
	return "employee/empAddForm";
}

@GetMapping("/deleteEmp")
public String deleteEmployee(@ModelAttribute("employeeId")int theId) {

	emplyoyeeService.deleteEmp(theId);
	
return "redirect:/employee/hello";
	
}
}