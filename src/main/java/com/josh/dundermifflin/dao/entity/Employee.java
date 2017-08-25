package com.josh.dundermifflin.dao.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Employees")
@DynamicUpdate
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	
	@Column(length=100)
	private String name;
	
	@Column(length=100)
	private String email;
	
	@Column(length=100)
	private String department;
	
	@Column(length=100)
	private String branch;
	
	@Column
	private int managerId;
	
	@Column(columnDefinition="longblob")
	private byte[] image;
	
	public Employee() {}
	
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
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", department="
				+ department + ", branch=" + branch + ", image=" + Arrays.toString(image) + "]";
	}
	
}
