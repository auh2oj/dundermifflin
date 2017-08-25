package com.josh.dundermifflin.web.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.entity.Employee;

@Controller
public class EmployeeController {
	
	private ApplicationContext context;
	private EmployeeDao ed;
	
	private EmployeeController() {
		context = new ClassPathXmlApplicationContext("employee-dao.xml");
		ed = (EmployeeDao) context.getBean("EmployeeDaoImpl");
	}

	@RequestMapping(value="addEmployee", method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		ed.addEmployee(employee);
		model.addAttribute("message", "Employee added successfully.");
		return "index";
	}
	
	@RequestMapping(value="showEmployees", method=RequestMethod.GET)
	public String showEmployees(Model model) {
		List<Employee> employeeList = ed.listEmployees();
		model.addAttribute("employeeList", employeeList);
		return "showEmployees";
	}
}
