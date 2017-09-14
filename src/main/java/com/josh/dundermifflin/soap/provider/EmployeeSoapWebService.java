package com.josh.dundermifflin.soap.provider;

import javax.jws.WebService;

import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@WebService
public class EmployeeSoapWebService {
	
	public EmployeeForm findEmployeeByName(String name) {
		EmployeeForm ef = new EmployeeForm();
		ef.setName("Andy Bernard");
		ef.setEmail("abernard@dm.com");
		ef.setDepartment("Sales");
		ef.setBranch("Scranton, PA");
		return ef;
	}
}
