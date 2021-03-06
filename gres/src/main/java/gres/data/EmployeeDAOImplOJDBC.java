package gres.data;

import gres.utility.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gres.model.Employee;
import gres.utility.CloseStreams;




public class EmployeeDAOImplOJDBC implements EmployeeDAO {
	
	static List<Employee> employeeList = new ArrayList<>();
	

	
	
	@Override
	public Employee getEmployee(String email, String password, int roleid) {
		
		PreparedStatement statement = null;
		ResultSet result = null;

		
		// We're going to do a try-with-resources
		// this lets us open a resource, like a db connection
		// as a part of starting our try block, and it
		// will be closed automatically when the try
		// block finishes.
		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("SELECT * FROM USER_ACCOUNT where email=? AND password=? AND roleid=?");
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setInt(3, roleid);
			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			if(result.next()) {
				
			email = result.getString("email");
			password = result.getString("password");
			roleid = result.getInt("roleid");
			System.out.println(email + " " + password);
			System.out.println("RoleID 1 in EmployeeDAOJDBC is: " + roleid);
			return new Employee(email, password, roleid);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(result);
		}
				
		for(Employee empl: employeeList) {
			if(empl.getEmail().equals(email)) {
				if(empl.getPassWord().equals(password)) {
					if(empl.getRoleId() == roleid) {
						System.out.println("RoleID 2 in EmployeeDAOJDBC is: " + roleid);
						return empl;
					}
					return null;
				}
				return null;
			}
			
		}
		return null;
		
	}

	@Override
	public Employee getEmployee(String email) {
		for(Employee empl: employeeList) {
			if(empl.getEmail().equals(email)) {
				return empl;
			}
		}
		return null;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeList.add(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getAccountInfo(String email, String password) {
		PreparedStatement statement = null;
		ResultSet result = null;


		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("SELECT * FROM USER_ACCOUNT where email=? AND password=?");
			statement.setString(1, email);
			statement.setString(2, password);

			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			if(result.next()) {
				
			email = result.getString("email");
			password = result.getString("password");

			System.out.println(email + " " + password);
			return new Employee(email, password);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(result);
		}
		return null;
	}

	@Override
	public Employee updateAccountInfo(String email, String password) {
		PreparedStatement statement = null;
		ResultSet result = null;


		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("SELECT * FROM USER_ACCOUNT where email=? AND password=?");
			statement.setString(1, email);
			statement.setString(2, password);

			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			if(result.next()) {
				
			email = result.getString("email");
			password = result.getString("password");

			System.out.println(email + " " + password);
			return new Employee(email, password);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(result);
		}
		return null;
	}
}
	

