package com.josh.dundermifflin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	private EmployeeService employeeService;
	
	private EmployeeController() {}

	@RequestMapping(value="addEmployee", method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute EmployeeForm ef, Model model) {
		employeeService.addEmployee(ef);
		model.addAttribute("message", "Employee added successfully.");
		return "index";
	}
	
	@RequestMapping(value="showEmployees", method=RequestMethod.GET)
	public String showEmployees(Model model) {
		List<EmployeeForm> employeeList = employeeService.listEmployees();
		model.addAttribute("employeeList", employeeList);
		return "showEmployees";
	}
}
