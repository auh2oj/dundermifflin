package com.josh.dundermifflin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.josh.dundermifflin.dao.EmployeeDao;
import com.josh.dundermifflin.service.AuthService;

@Service("AuthServiceImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	@Qualifier("EmployeeDaoImpl")
	private EmployeeDao employeeDao;

	public String authUser(String username, String password) {
		return employeeDao.authUser(username, password);
	}

}
