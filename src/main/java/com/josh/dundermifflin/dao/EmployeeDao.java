package com.josh.dundermifflin.dao;

import java.util.List;

import com.josh.dundermifflin.dao.entity.Employee;

public interface EmployeeDao {

	public String addEmployee(Employee e);
	
	public List<Employee> listEmployees();
}
