package dbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Board;
import Entities.User;

public class UserQueries {

	private DatabaseConnection databaseConnection = new DatabaseConnection();
	private User user;
	private int id;
	private Board board;

	public UserQueries(User user) throws SQLException {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	
	public UserQueries(Board board) throws SQLException {
		// TODO Auto-generated constructor stub
		this.board = board;
	}

	public ResultSet signIn(String email, String password) throws SQLException {
		String statement = "select * from User where email = '" + email + "' AND password = '" + password + "'";
		// syntax: select * from User where email = 'm@g.com'
		System.out.println("sql statment: " + statement);
		ResultSet result = databaseConnection.executeQuery(statement);
		System.out.println("query executed");
		return result;
	}

	public void signUp() throws SQLException {
		id = this.getLastID();
		String statement = "insert into User values ('" + user.getName().toString() + "', " + String.valueOf(id + 1)
				+ " ,'admin','" + user.getEmail().toString() + "','" + user.getPassword().toString() + "','"
				+ user.getGender().toString() + "')";
		// String statement = "insert into Sensor values
		// ('tv',3,'24442','3424','AKOEO29301','fun',true,true,true,233)";
		System.out.println("sql statment: " + statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");
	}

	public void addUser(int boardID) throws SQLException {
		
		//id = this.getLastID();
		//boardID = this.getLastID();

		String statement = "insert into userBoard(' " + String.valueOf(user.getId())
		+ "', " + String.valueOf(board.getId()) + " ') ";

		System.out.println("sql statment: " + statement);
		databaseConnection.executeQuery(statement);
		System.out.println("query executed");
	}

	public void removeUser(int boardID) throws SQLException {

		String statement = "delete from userBoard(' " + String.valueOf(user.getId()) + "')";

		System.out.println("sql statment: " + statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");

	}

	public void deleteAccount() throws SQLException {

		String statement = "delete from User(' " + String.valueOf(id) + "')";

		System.out.println("sql statment: " + statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");

	}

	public int getLastID() throws SQLException {
		databaseConnection = new DatabaseConnection();
		ResultSet resultSet = databaseConnection.executeQuery("Select max(userID) from User");
		resultSet.next();
		if(resultSet.getString(1) == null){
			return 0;
		}
		return Integer.parseInt(resultSet.getString(1));

	}
}
