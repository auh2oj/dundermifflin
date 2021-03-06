package com.josh.dundermifflin.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
import com.josh.dundermifflin.dao.entity.LoginEntity;
import com.josh.dundermifflin.util.ApplicationConstants;
import com.josh.dundermifflin.util.Queries;

@Repository("EmployeeDaoImpl")
@Scope("singleton")
@Transactional
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	
	@Autowired
	@Qualifier("employeeSessionFactory")
	public void setCustomerSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public String addEmployee(Employee e) {
		super.getHibernateTemplate().save(e);
		return ApplicationConstants.SUCCESS;
	}

	public List<Employee> listEmployees() {
		List<Employee> employeeList = 
				(List<Employee>) super.getHibernateTemplate().find("from Employee");
		return employeeList;
	}

	public String changePhoto(Employee employee) {
		Employee e = getHibernateTemplate().load(Employee.class, employee.getEmployeeId());
		e.setImage(employee.getImage());
		
//		super.getHibernateTemplate().update(e);
		return ApplicationConstants.SUCCESS;
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee e = getHibernateTemplate().load(Employee.class, employee.getEmployeeId());
		//BeanUtils.copyProperties(employee, e);
		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setDepartment(employee.getDepartment());
		e.setBranch(employee.getBranch());
		return e;
	}

	public byte[] findImageByEid(int eid) {
		Employee e = super.getHibernateTemplate().load(Employee.class, eid);
		return e.getImage();
	}

	public String deleteEmployee(int employeeId) {
		Employee employee = getHibernateTemplate().load(Employee.class, employeeId);
		getHibernateTemplate().delete(employee);
		return ApplicationConstants.DELETED;
	}

	public List<Integer> listEmployeesByEid() {
		String sql = "Select employeeId from Employee";
		return (List<Integer>) getHibernateTemplate().find(sql);
	}

	public Employee findEmployeeByEid(int eid) {
		return getHibernateTemplate().get(Employee.class, eid);
	}

	public String authUser(String username, String password) {
		String role = "";
		List<LoginEntity> loginList = (List<LoginEntity>) getHibernateTemplate()
				.find("from LoginEntity where username=? and password=?", username, password);
		if (loginList.isEmpty()) return role;
		else {
			role = loginList.get(0).getRole();
			return role;
		}
	}

	public LoginEntity findRoleByUsername(String username) {
		LoginEntity login = null;
		List<LoginEntity> list = (List<LoginEntity>) getHibernateTemplate().find("from LoginEntity where username=?", username);
		if (list.isEmpty()){
			login = null;
		} else {
			login = list.get(0);
		}
		return login;
	}

	/*
	 * Retrieves Employee from the database that has the name @param ename
	 * @see com.josh.dundermifflin.dao.EmployeeDao#findEmployeeByName(java.lang.String)
	 */
	public List<Employee> findEmployeeByName(String ename) {
		List<Employee> employeeList = (List<Employee>) super.getHibernateTemplate()
				.find("from Employee where name=?", ename);
		return employeeList;
	}

}
