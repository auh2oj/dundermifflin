package com.josh.dundermifflin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josh.dundermifflin.entity.Employee;
import com.josh.dundermifflin.util.Queries;

@Repository("EmployeeDaoImpl")
@Scope("singleton")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate template;

	public String addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> listEmployees() {
		List<Employee> employeeList = template
				.query(Queries.SHOW_EMPLOYEES,
						new BeanPropertyRowMapper(Employee.class));
		return employeeList;
	}

}
