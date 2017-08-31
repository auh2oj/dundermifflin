package com.josh.dundermifflin.service;

import java.util.List;

import com.josh.dundermifflin.web.controller.model.EmployeeForm;

public interface EmployeeService {
	
	public String addEmployee(EmployeeForm ef);
	
	public List<EmployeeForm> listEmployees();
	
	public List<Integer> listEmployeesByEid();
	
	public EmployeeForm findEmployeeFormByEid(int eid);
	
	public String changePhoto(EmployeeForm ef);
	
	public String updateEmployee(EmployeeForm ef);
	
	public byte[] findImageByEid(int eid);
	
	public String deleteEmployee(int employeeId);
}
