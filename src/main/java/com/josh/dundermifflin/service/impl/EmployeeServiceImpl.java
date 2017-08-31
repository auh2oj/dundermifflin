package com.josh.dundermifflin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@Service("EmployeeServiceImpl")
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
			BeanUtils.copyProperties(employee, employeeForm);
			employeeFormList.add(employeeForm);
		}
		return employeeFormList;
	}

	public String changePhoto(EmployeeForm ef) {
		Employee e = new Employee();
		BeanUtils.copyProperties(ef, e);
		return employeeDao.changePhoto(e);
	}
	
	public String updateEmployee(EmployeeForm ef) {
		Employee e = new Employee();
		BeanUtils.copyProperties(ef, e);
		return employeeDao.updateEmployee(e);
	}

	public byte[] findImageByEid(int eid) {
		return employeeDao.findImageByEid(eid);
	}

	public String deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	public List<Integer> listEmployeesByEid() {
		return employeeDao.listEmployeesByEid();
	}

	public EmployeeForm findEmployeeFormByEid(int eid) {
		Employee e = employeeDao.findEmployeeByEid(eid);
		EmployeeForm ef = new EmployeeForm();
		BeanUtils.copyProperties(e, ef);
		return ef;
	}

}
