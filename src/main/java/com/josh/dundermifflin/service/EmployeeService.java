package com.josh.dundermifflin.service;

import java.util.List;

import com.josh.dundermifflin.web.controller.model.EmployeeForm;

public interface EmployeeService {
	public String addEmployee(EmployeeForm ef);
	public List<EmployeeForm> listEmployees();
}
