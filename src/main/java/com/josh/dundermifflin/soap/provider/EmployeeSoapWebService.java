package com.josh.dundermifflin.soap.provider;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@WebService // Makes the class behave as a SOAP provider
@Service("EmployeeSoapWebService")
public class EmployeeSoapWebService {
	
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	EmployeeService employeeService;
	
	public /*EmployeeForm*/ List<EmployeeForm> findEmployeeByName(String name) {
//		EmployeeForm ef = new EmployeeForm();
//		ef.setName("Andy Bernard");
//		ef.setEmail("abernard@dm.com");
//		ef.setDepartment("Sales");
//		ef.setBranch("Scranton, PA");
//		return ef;
		List<EmployeeForm> efList = employeeService.findEmployeeByName(name);
		return efList;
	}
}
