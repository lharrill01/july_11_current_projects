package com.project1.login;

public class ELogin {
	
	int id;
	String firstName;
	String lastName;
	String email;
	String role;
	String passWord;
	int roleId;
	
	// Declared Constructor
	public ELogin(String email, String passWord, int roleId) {
		super();
		this.email = email;
		this.passWord = passWord;
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "ELogin [email=" + email + ", passWord=" + passWord + ", roleId=" + roleId + "]";
	}



}
