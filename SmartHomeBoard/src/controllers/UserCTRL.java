package controllers;

import java.sql.SQLException;

import Entities.User;
import dbAccess.UserQueries;

public class UserCTRL {
	private User user;
	public UserCTRL(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	public void signIn() throws SQLException{
		UserQueries query = new UserQueries(user);
		query.signIn();
	}
	public void SignOut(){}
	public void signUp() throws SQLException{
		UserQueries query = new UserQueries(user);
		query.signUp();
	}
	public void addUser() throws SQLException{
		UserQueries query = new UserQueries(user);
		query.addUser();
	}
	public void removeUser() throws SQLException{
		UserQueries query = new UserQueries(user);
		query.removeUser();
	}
	public void deleteAccount() throws SQLException{
		UserQueries query = new UserQueries(user);
		query.deleteAccount();
	}
	
}
