package com.josh.dundermifflin.util;

public interface Queries {

	public static final String SHOW_EMPLOYEES = "Select * from Employees";
	public static final String ADD_EMPLOYEE = "Insert into Employees"
			+ "(employeeId, name, email, department, branch, managerId, image)"
			+ "values (?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_EMPLOYEE_IMAGE = "Update Employees"
			+ "set image=? where employeeId=?";
	public static final String DELETE_EMPLOYEE = "Delete from Employees"
			+ "where employeeId=?";
	public static final String FIND_EMPLOYEE_IMAGE_EID = "select image from Employees"
			+ "where employeeId=?";
}
