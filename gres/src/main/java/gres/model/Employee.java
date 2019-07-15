package gres.model;

public class Employee {


	String email;
	String password;
	int roleId;
	
	public Employee( String email, String password, int roleId) {
		super();
		this.email = email;
		this.password = password;
		this.roleId = roleId;
	}
	
	



//	public Employee(String email2, String password2) {
//		// TODO Auto-generated constructor stub
//	}





	public Employee(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}





	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassWord() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email
				+ ", password=" + password + ", roleId=" + roleId + "]";
	}
	
	
	
}
