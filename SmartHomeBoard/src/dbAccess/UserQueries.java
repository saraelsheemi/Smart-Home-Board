package dbAccess;

import java.sql.SQLException;

import Entities.User;

public class UserQueries {
	private DatabaseConnection databaseConnection=new DatabaseConnection();
	private User user;
	public UserQueries(User user) throws SQLException {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	public void signIn(){
		
	}
	public void signUp() throws SQLException{
		String statement="insert into User values ('"+ user.getName().toString() +"','admin','"+user.getEmail().toString()+"','"+user.getPassword().toString()+"','"+user.getGender().toString()+"')";
		//String statement = "insert into Sensor values ('tv',3,'24442','3424','AKOEO29301','fun',true,true,true,233)";
		System.out.println("sql statment: "+statement);
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
