package com.josh.dundermifflin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@Controller
@RequestMapping("/rest")
public class EmployeeRestController {
	
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET,
			produces = {"application/json"})
	@ResponseBody public List<EmployeeForm> listEmployees() {
		List<EmployeeForm> employeeList = employeeService.listEmployees();
		return employeeList;
		
		//localhost:8080/employeedirectory/rest/employees
	}

}
