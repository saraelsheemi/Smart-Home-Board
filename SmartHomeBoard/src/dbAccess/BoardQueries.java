package dbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Board;

public class BoardQueries {
	private DatabaseConnection databaseConnection=new DatabaseConnection();;
	private Board board;
	public BoardQueries(Board board) throws SQLException {
		// TODO Auto-generated constructor stub
		this.board = board;
	}
	public void addBoard() throws SQLException{
		databaseConnection = new DatabaseConnection();
		int id = getLastID() + 1;
		String statement="insert into Board values ('"+board.getName()+"',"+String.valueOf(id+1)+",null)";
		System.out.println(statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");

	}
	public void removeBoard() throws SQLException{
		databaseConnection = new DatabaseConnection();
		String statement="delete from Board where boardID = " + String.valueOf(board.getId());
		databaseConnection.executeUpdate(statement);
		System.out.println(statement);
	}
	public int getLastID() throws SQLException{
		databaseConnection = new DatabaseConnection();
		ResultSet resultSet = databaseConnection.executeQuery("Select max(boardID) from Board");
		resultSet.next();
		return Integer.parseInt(resultSet.getString(1));		

	}
}
