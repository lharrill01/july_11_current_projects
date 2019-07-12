package com.project1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String role;
	private String passWord;
	private int roleId;
	
	public Employee(int id, String firstName, String lastName, String userName, String role, String passWord, int roleId) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.role = role;
		this.passWord = passWord;
		this.roleId = roleId;
	}
	
	public Employee(ResultSet rS) throws SQLException{
		this(rS.getInt("id"),
			rS.getString("firsName"),
			rS.getString("lastName"),
			rS.getString("userName"),
			rS.getString("role"),
			rS.getString("passWord"),
			rS.getInt("roleId"));
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + userName
				+ ", role=" + role + ", passWord=" + passWord + ", roleId=" + roleId + "]";
	}
	
	
	
	
}
