package gres.data;

import gres.model.Employee;
import gres.model.Reimbursement;
import gres.model.ReimbursementNoId;

public interface ReimbursementDAO {


	/**
	 * Single line description
	 * 
	 * information about params and return
	 */
	
	/**
	 * Gets Employee from DB based on email and password
	 * 
	 * @param email email of the employee
	 * @param password password of the employee
	 * @return the employee from the DB that matches email and password
	 */
	public Reimbursement getReimbursement(int id, String email, String rStuff, double rAmount, String adchoice);
	
	public ReimbursementNoId getReimbursementNoId(String email, String rStuff, double rAmount, String adchoice);

	
	/**
	 * Gets employee from DB based on id
	 * 
	 * @param id
	 * @return the employee from the DB that matches given id
	 */
	public Reimbursement updateReimbursement(int id, String email, String rStuff, double rAmount, String adchoice);

	public ReimbursementNoId updateReimbursementNoId(String email, String rStuff, double rAmount, String adchoice);

	/**
	 * Creates a new employee in the DB
	 * 
	 * @param employee the Employee that should be created
	 * @return true or false based on success or failure of employee creation
	 */

	public Reimbursement createReimbursement(int id, String email, String rStuff, double rAmount, String adchoice);
	
	public ReimbursementNoId createReimbursementNoId(String email, String rStuff, double rAmount, String adchoice);
	
	
}
