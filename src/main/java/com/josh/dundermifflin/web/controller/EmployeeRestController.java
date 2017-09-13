package com.josh.dundermifflin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.util.ApplicationMessageResponse;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@Controller
@RequestMapping("/rest")
public class EmployeeRestController {
	
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET,
			produces = {"application/json"})//delete xml if needed
	@ResponseBody public List<EmployeeForm> listEmployees() {
		List<EmployeeForm> employeeList = employeeService.listEmployees();
		return employeeList;
		
		//localhost:8080/employeedirectory/rest/employees
	}
	
	@RequestMapping(value="/find/{ename}", method=RequestMethod.GET,
			produces = {"application/json"})
	@ResponseBody public List<EmployeeForm> findEmployee(@PathVariable("ename") String ename) {
		List<EmployeeForm> employeeList = employeeService.findEmployeeByName(ename);
		return employeeList;
	}
	
	@RequestMapping(value="/deleteEid/{eid}", method=RequestMethod.DELETE,
			produces = {"application/json", "application/xml"})
	@ResponseBody public ApplicationMessageResponse deleteEmployee(@PathVariable("eid") int eid) {
		String status = employeeService.deleteEmployee(eid);
		ApplicationMessageResponse amr = new ApplicationMessageResponse();
		amr.setStatus("success");
		amr.setMessage("Employee data has been successfully deleted.");
		return amr;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT,
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})
	@ResponseBody public ApplicationMessageResponse updateEmployee(@RequestBody EmployeeForm ef) {
		System.out.println(ef);
		employeeService.addEmployee(ef);
		ApplicationMessageResponse amr = new ApplicationMessageResponse();
		amr.setStatus("success");
		amr.setMessage("Employee data has been successfully updated.");
		return amr;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST,
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})
	@ResponseBody public ApplicationMessageResponse addEmployee(@RequestBody EmployeeForm ef) {
		System.out.println(ef);
		employeeService.addEmployee(ef);
		ApplicationMessageResponse amr = new ApplicationMessageResponse();
		amr.setStatus("success");
		amr.setMessage("Employee data has been successfully added.");
		return amr;
	}

}
