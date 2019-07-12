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
	public Reimbursement getReimbursement(int id, String email, String selection, double rAmount, boolean adchoice) {

		PreparedStatement statement = null;

		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("UPDATE Reimbursement_pool SET ID=?, EMAIL=?, SELECTION=?, ADCHOICE=?");
			statement.setInt(1, id);
			statement.setString(2, email);
			statement.setString(3, selection);
			statement.setBoolean(4, adchoice);
			
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
	public Reimbursement updateReimbursement(int id, String email, String selection, double rAmount, boolean adchoice) {
		PreparedStatement statement = null;
		ResultSet result = null;

		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("SELECT * FROM Reimbursement_pool where email=?");
			statement.setInt(1, id);
			statement.setString(2, email);
			statement.setString(3, selection);
			statement.setBoolean(4, adchoice);
			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			if(result.next()) {
				
			id = result.getInt("id");
			email = result.getString("email");
			selection = result.getString("selection");
			adchoice = result.getBoolean("adchoice");
			
			System.out.println(email + " " + adchoice);
			System.out.println("RoleID 1 in EmployeeDAOJDBC is: " + adchoice);
			return new Reimbursement(id, email, selection, rAmount, adchoice);
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
	public Reimbursement createReimbursement(int id, String email, String selection, double rAmount, boolean adchoice) {
		PreparedStatement statement = null;
		ResultSet result = null;

		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.prepareStatement("SELECT * FROM Reimbursement_pool where email=?");
			statement.setInt(1, id);
			statement.setString(2, email);
			statement.setString(3, selection);
			statement.setBoolean(4, adchoice);
			
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			statement.execute();
			// ResultSet stores all the results from a successful query
			result = statement.getResultSet();
			// Create ourselves a new PetType object for each row:
			if(result.next()) {
				
			id = result.getInt("id");
			email = result.getString("email");
			selection = result.getString("selection");
			adchoice = result.getBoolean("adchoice");
			
			System.out.println(email + " " + adchoice);
			System.out.println("RoleID 1 in EmployeeDAOJDBC is: " + adchoice);
			return new Reimbursement(id, email, selection, rAmount, adchoice);
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
