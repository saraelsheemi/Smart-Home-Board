import java.sql.*;

public class DatabaseConnectionTest {

	private Connection dbConnection;
	
	public static void main(String args[]){
		DatabaseConnectionTest test;
		try {
			test = new DatabaseConnectionTest();
			test.executeUpdate("insert into User (userName, userID) values ('ahmed', 2552)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public DatabaseConnectionTest() throws SQLException {
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

	public int executeUpdate(String sqlQuery) throws SQLException {
		Statement statement = dbConnection.createStatement();
		statement.executeUpdate(sqlQuery);

		return 0;

	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// dbConnection.prepareStatement(sql);
		return dbConnection.prepareStatement(sql);
	}
	

}
