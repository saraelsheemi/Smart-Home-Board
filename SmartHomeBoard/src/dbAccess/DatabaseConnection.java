package dbAccess;

import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;


public class DatabaseConnection {
	private Connection dbConnection;
	
	public DatabaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11169212";
			String userName = "sql11169212";
			String password = "b6gW4xKsK1";
			// get a connection to database with the connection string URL
			dbConnection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create a statement to be executed on the target database
	}

	public ResultSet executeQuery(String sqlQuery) throws SQLException {
		Statement statement = dbConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		return resultSet;

	}

	public void executeUpdate(String sqlQuery) throws SQLException {
		Statement statement = dbConnection.createStatement();
		statement.executeUpdate(sqlQuery);
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// dbConnection.prepareStatement(sql);
		return dbConnection.prepareStatement(sql);
	}
	public void closeConnection() throws SQLException{
		dbConnection.close();
	}

}
