package com.josh.dundermifflin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier("EmployeeDaoImpl")
	private EmployeeDao employeeDao;

	public String addEmployee(EmployeeForm ef) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(ef, employee);
		String result = employeeDao.addEmployee(employee);
		return result;
	}

	public List<EmployeeForm> listEmployees() {
		List<Employee> employeeList = employeeDao.listEmployees();
		List<EmployeeForm> employeeFormList = new ArrayList<EmployeeForm>();
		for (Employee employee : employeeList) {
			EmployeeForm employeeForm = new EmployeeForm();
			BeanUtils.copyProperties(employeeForm, employee);
			employeeFormList.add(employeeForm);
		}
		return employeeFormList;
	}

}
