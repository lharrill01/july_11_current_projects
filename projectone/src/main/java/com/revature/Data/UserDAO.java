package com.revature.Data;

import com.revature.model.User;

public interface UserDAO {

	/**
	 * Single line description
	 * 
	 * information about params and return
	 */
	
	/**
	 * Gets User from DB based on username and password
	 * 
	 * @param username username of the user
	 * @param password password of the user
	 * @return the user from the DB that matches username and password
	 */
	public User getUser(String username, String password);
	
	/**
	 * Gets User from DB based on id
	 * 
	 * @param id
	 * @return the user from the DB that matches given id
	 */
	public User getUser(long id);
	
	/**
	 * Creates a new user in the DB
	 * 
	 * @param user the User that should be created
	 * @return true or false based on success or failure of user creation
	 */
	public boolean createUser(User user);
}
