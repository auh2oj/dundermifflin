package com.josh.dundermifflin.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.dao.entity.Employee;
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
		super.getHibernateTemplate().update(employee);
		return ApplicationConstants.SUCCESS;
	}

	public byte[] findImageByEid(int eid) {
		Employee e = super.getHibernateTemplate().load(Employee.class, eid);
		return e.getImage();
	}

}
