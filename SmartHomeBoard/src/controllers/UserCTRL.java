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
		return u;
	}

	public void SignOut() {
	}

	public void signUp() throws SQLException {
		UserQueries query = new UserQueries(user);
		query.signUp();
	}

	public void addUser(int boardID) throws SQLException {
		UserQueries query = new UserQueries(user);
		query.addUser(boardID);
	}

	public void removeUser(int boardID) throws SQLException {
		UserQueries query = new UserQueries(user);
		query.removeUser(boardID);
	}

	public void deleteAccount() throws SQLException {
		UserQueries query = new UserQueries(user);
		query.deleteAccount();
	}

}
