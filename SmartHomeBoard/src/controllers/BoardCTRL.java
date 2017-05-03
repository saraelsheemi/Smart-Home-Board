package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<Board> getuserBoardsInfo() throws SQLException{
		ArrayList<Board> boards = new ArrayList<Board>(); //array of boards that the user has
		ArrayList<Integer> ids = new ArrayList<Integer>(); //the array of id's if the user boards
		BoardQueries query = new BoardQueries(board);
		ResultSet result = query.getUserBoardsIDs();
		int boardCount = 0;
		while(result.next()){
			System.out.println("while");
			boardCount++;
			ids.add(Integer.valueOf(result.getString("boardID")));
			System.out.println(ids);
		}
		Board tempBoard; 
		for(int i=0; i<boardCount; i++){
			tempBoard = new Board();
			System.out.println(i+" "+boardCount);
			result = query.getboardInfo(ids.get(i));
			System.out.println(ids.get(i));
			result.next();
			tempBoard.setName(result.getString("boardName").toString());
			tempBoard.setId(Integer.valueOf(result.getString("boardID").toString()));
			tempBoard.setOwnerId(board.getOwnerId());
			System.out.println(tempBoard.getId());
			boards.add(tempBoard);
		}
		System.out.println(boards.toString());
		return boards;
	}
	

}
