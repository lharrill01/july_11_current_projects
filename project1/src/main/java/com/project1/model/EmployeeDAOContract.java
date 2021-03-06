package com.project1.model;

import java.util.List;

public interface EmployeeDAOContract {

	public Employee getEmployeeView(int id);
	public void updateAccountInfo(Employee employee);
	public void viewPendingReimbursementsRequests(int id);
	public void viewResolvedReimbursementRequests(int id);
	public Employee getEmployee(String userName, String passWord, int roleId);

	
}
