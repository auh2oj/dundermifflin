package com.josh.dundermifflin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.service.EmployeeService;
import com.josh.dundermifflin.web.controller.model.EmployeeForm;

@Service("EmployeeServiceImpl")
@Transactional(propagation=Propagation.REQUIRED)
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

	@Cacheable(value="employee-cache")
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
	
	@CachePut(value="employee-cache", key="#ef.employeeId")
	public EmployeeForm updateEmployee(EmployeeForm ef) {
		Employee e = new Employee();
		BeanUtils.copyProperties(ef, e);
		Employee de=employeeDao.updateEmployee(e);
		EmployeeForm ref=new EmployeeForm();
		BeanUtils.copyProperties(de, ref);
		return ref;
	}
	

	//@Cacheable(value="employee-cache", key="#eid")
	public byte[] findImageByEid(int eid) {
		return employeeDao.findImageByEid(eid);
		//return null;
	}

	@CacheEvict(value="employee-cache", key="#employeeId")
	public String deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	public List<Integer> listEmployeesByEid() {
		return employeeDao.listEmployeesByEid();
	}

	@Cacheable(value="employee-cache", key="#eid")
	public EmployeeForm findEmployeeFormByEid(int eid) {
		Employee e = employeeDao.findEmployeeByEid(eid);
		EmployeeForm ef = new EmployeeForm();
		BeanUtils.copyProperties(e, ef);
		return ef;
	}

	public List<EmployeeForm> findEmployeeByName(String ename) {
		List<Employee> employeeList = employeeDao.findEmployeeByName(ename);
		List<EmployeeForm> employeeFormList = new ArrayList<EmployeeForm>();
		for (Employee e : employeeList) {
			EmployeeForm ef = new EmployeeForm();
			BeanUtils.copyProperties(e, ef);
			employeeFormList.add(ef);
		}
		return employeeFormList;
	}

}
