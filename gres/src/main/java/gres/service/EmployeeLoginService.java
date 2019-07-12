package gres.service;

import gres.data.EmployeeDAO;
import gres.model.Employee;

public class EmployeeLoginService {
	
	EmployeeDAO employeeDAO;
	static EmployeeLoginService ls;
	
	private EmployeeLoginService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		
	}

	public static EmployeeLoginService getInstance(EmployeeDAO employeeDAO) {
		if(ls == null) {
			ls = new EmployeeLoginService(employeeDAO);
			return ls;
		}
		else {
			return ls;
		}
	}

	public static EmployeeLoginService getInstance() {
		if(ls == null) {
			
			throw new RuntimeException("EmployeeLoginService not instantiated wit EmployeeDAO");
		}
		return ls;
	}
	
	public boolean validate(String email, String password, int roleid) {
		
		Employee employee = employeeDAO.getEmployee(email, password, roleid);
		return employee == null ? false : true;
	}
	
	public Employee getEmployee(String email, String password, int roleid) {
		Employee employee = employeeDAO.getEmployee(email, password, roleid);

		return employee;
	}
	
	public boolean addEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
		
	}
	public boolean updateEmployee(Employee employee) {
		
		return employeeDAO.updateEmployee(employee);
	}
	
	
}
