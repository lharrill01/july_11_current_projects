package gres.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gres.model.Reimbursement;
import gres.utility.CloseStreams;
import gres.utility.ConnectionUtility;

public class ReimbursementDAOImplOJDBC implements ReimbursementDAO {

	@Override
	public Reimbursement getReimbursement(int id, String email, String rStuff, double rAmount, String adchoice) {

		PreparedStatement statement = null;

		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("insert into Reimbursement_pool(id, email, rStuff, rAmount, adchoice) values(?,?,?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, email);
			statement.setString(3, rStuff);
			statement.setString(4, adchoice);
			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			// Create ourselves a new PetType object for each row:

		} 
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CloseStreams.close(statement);

		}
		
		
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(int id, String email, String rStuff, double rAmount, String adchoice) {
		PreparedStatement statement = null;
		ResultSet result = null;

		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement(" * FROM Reimbursement_pool where email=?");
			statement.setInt(1, id);
			statement.setString(2, email);
			statement.setString(3, rStuff);
			statement.setString(4, adchoice);
			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			result.next();
				
			id = result.getInt("id");
			email = result.getString("email");
			rStuff = result.getString("rStuff");
			adchoice = result.getString("adchoice");
			
			System.out.println(email + " " + adchoice);
			System.out.println("RoleID 1 in EmployeeDAOJDBC is: " + adchoice);
			return new Reimbursement(id, email, rStuff, rAmount, adchoice);
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(result);
		}
		
		
		//return null;
	}

	@Override
	public Reimbursement createReimbursement(int id, String email, String rStuff, double rAmount, String adchoice) {
		PreparedStatement statement = null;
		ResultSet result = null;

		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("insert into Reimbursement_pool(id, email, rStuff, rAmount, adchoice) values(?,?,?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, email);
			statement.setString(3, rStuff);
			statement.setDouble(4, rAmount);			
			statement.setString(5, adchoice);
			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			if(result.next()) {
				
			id = result.getInt("id");
			email = result.getString("email");
			rStuff = result.getString("rStuff");
			rAmount = result.getDouble("rAmount");
			adchoice = result.getString("adchoice");
			
			System.out.println(email + " " + adchoice);
			System.out.println("RoleID 1 in EmployeeDAOJDBC is: " + adchoice);
			return new Reimbursement(id, email, rStuff, rAmount, adchoice);
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
