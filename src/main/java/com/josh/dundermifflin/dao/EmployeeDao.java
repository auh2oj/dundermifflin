package com.josh.dundermifflin.dao;

import java.util.List;

import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.dao.entity.LoginEntity;

public interface EmployeeDao {

	public String addEmployee(Employee e);
	
	public List<Employee> listEmployees();
	
	public List<Integer> listEmployeesByEid();
	
	public Employee findEmployeeByEid(int eid);
	
	public String changePhoto(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public byte[] findImageByEid(int eid);
	
	public String deleteEmployee(int employeeId);
	
	public String authUser(String username, String password);

	public LoginEntity findRoleByUsername(String username);
	
	public List<Employee> findEmployeeByName(String ename);
}
