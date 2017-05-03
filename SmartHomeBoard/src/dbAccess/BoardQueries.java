package dbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		//insert new board table with the name and id 
		String statement="insert into Board values ('"+board.getName()+"',"+String.valueOf(id)+",null)";
		System.out.println(statement);
		databaseConnection.executeUpdate(statement);
		//link new board created to the user
		statement="insert into userBoard values('"+String.valueOf(board.getOwnerId())+"','"+String.valueOf(id)+"')";
		System.out.println(statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");

	}
	public void removeBoard() throws SQLException{
		String statement="delete from userBoard where boardID = " + String.valueOf(board.getId());
		databaseConnection.executeUpdate(statement);
		System.out.println(statement);
		databaseConnection = new DatabaseConnection();
		statement="delete from Board where boardID = " + String.valueOf(board.getId());
		databaseConnection.executeUpdate(statement);
		System.out.println(statement);
	}
	public ResultSet getUserBoardsIDs() throws SQLException{
		String statement="select boardID from userBoard where userID = "+ String.valueOf(board.getOwnerId());
		System.out.println(statement);
		ResultSet result;
		result = databaseConnection.executeQuery(statement);
		System.out.println(result.toString());
		return result;
	}
	public ResultSet getboardInfo(int boardID) throws SQLException{
		String statement = "select * from Board where boardID = "+String.valueOf(boardID);
		System.out.println(statement);
		ResultSet result = databaseConnection.executeQuery(statement);
		return result;
	}
	public int getLastID() throws SQLException{
		databaseConnection = new DatabaseConnection();
		ResultSet resultSet = databaseConnection.executeQuery("Select max(boardID) from Board");
		resultSet.next();
		return Integer.parseInt(resultSet.getString(1));		

	}
}
