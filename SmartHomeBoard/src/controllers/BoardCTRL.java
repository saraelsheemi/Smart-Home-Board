package controllers;

import java.sql.SQLException;

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
	

}
