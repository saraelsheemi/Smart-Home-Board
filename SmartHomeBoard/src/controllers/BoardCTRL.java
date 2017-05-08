package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import Entities.Board;
import dbAccess.BoardQueries;

public class BoardCTRL {
	private Board board;
	public BoardCTRL(Board board){
		this.board = board;
	}
	public void addBoard() throws SQLException{
		BoardQueries query = new BoardQueries(board);
		query.addBoard();
	}
	public void removeBoard() throws SQLException{
		BoardQueries query = new BoardQueries(board);
		query.removeBoard();
	}
	@SuppressWarnings("unchecked")
	public ArrayList<JSONObject> getUserBoards() throws SQLException{
		ArrayList<JSONObject> boards = new ArrayList<JSONObject>(); //array of boards that the user has
		ArrayList<Integer> ids = new ArrayList<Integer>(); //the array of id's if the user boards
		BoardQueries query = new BoardQueries(board);
		ResultSet result = query.getUserBoardsIDs();
		while(result.next()){
			ids.add(Integer.valueOf(result.getString("boardID")));
		}
		System.out.println("the user has boards with ids: "+ids.toString()); 
		int boardCount = ids.size();
		for(int i=0; i<boardCount; i++){
			JSONObject temp = new JSONObject();
			result = query.getboardInfo(ids.get(i));
			result.next();
			temp.put("boardName",result.getString("boardName").toString());
			temp.put("boardID",result.getString("boardID").toString());
			boards.add(temp);
		}
		System.out.println(boards.toString());
		return boards;
	}
	

}
