package controllers;

import java.sql.SQLException;
import java.sql.ResultSet;

import Entities.Board;
import Entities.User;
import dbAccess.UserQueries;

public class UserCTRL {

	private User user;

	public UserCTRL(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	public User signIn() throws SQLException {
		UserQueries query = new UserQueries(user);
		ResultSet result = query.signIn(user.getEmail(), user.getPassword());
		result.next();
		User u = new User(result.getInt("userID"), result.getString("userName"), result.getString("userType"),
				result.getString("gender"), result.getString("email"), result.getString("password"));
		query.getConnection().closeConnection();
		return u;
	}
	public void signUp() throws SQLException {
		UserQueries query = new UserQueries(user);
		query.signUp();
		query.getConnection().closeConnection();
	}

	public void addUser(int boardID) throws SQLException {
		UserQueries query = new UserQueries(user);
		query.addUser(boardID);
		query.getConnection().closeConnection();
	}

	public void removeUser(int boardID) throws SQLException {
		UserQueries query = new UserQueries(user);
		query.removeUser(boardID);
		query.getConnection().closeConnection();
	}

	public void deleteAccount() throws SQLException {
		UserQueries query = new UserQueries(user);
		query.deleteAccount();
		query.getConnection().closeConnection();
	}

}
