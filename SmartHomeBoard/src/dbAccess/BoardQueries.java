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
	public void addBoard(){
		
	}
	public void removeBoard(){
		
	}
	public int getLastID() throws SQLException{
		databaseConnection = new DatabaseConnection();
		ResultSet resultSet = databaseConnection.executeQuery("Select max(boardID) from Board");
		resultSet.next();
		return Integer.parseInt(resultSet.getString(1));		

	}
}
