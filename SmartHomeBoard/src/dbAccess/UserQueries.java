package dbAccess;

import java.sql.SQLException;

import Entities.User;

public class UserQueries {
	private DatabaseConnection databaseConnection;
	private User user;
	public UserQueries(User user) throws SQLException {
		// TODO Auto-generated constructor stub
		this.user = user;
		databaseConnection = new DatabaseConnection();
	}
	public void signIn(){
		
	}
	public void signUp() throws SQLException{
		String statement = "insert into User values ('"+user.getName()+"',1,'"
	+user.getType()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getGender()+"')";
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");

	}
	public void addUser(){
		
	}
	public void  removeUser(){
		
	}
	public void deleteAccount(){
		
	}
}
