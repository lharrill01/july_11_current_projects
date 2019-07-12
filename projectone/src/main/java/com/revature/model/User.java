package com.revature.model;

import com.revature.Data.UserDAO;

public class User implements UserDAO {

	
	private long id;
	private String username;
	private String password;
	private String role;
	private String name;

	// null user constructor:
	User() {
		super();
	}

	public User(long id, String username, String password, String role, String name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", name="
				+ name + "]";
	}

	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
