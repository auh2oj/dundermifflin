package com.josh.dundermifflin.web.controller.model;

import java.util.Arrays;

public class EmployeeForm {

	private int employeeId;
	private String name;
	private String email;
	private String department;
	private String branch;
	private int managerId;
	private byte[] image;
	
	public EmployeeForm() {}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "EmployeeForm [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", department="
				+ department + ", branch=" + branch + ", image=" + Arrays.toString(image) + "]";
	}
	
}

