package controllers;

import Entities.Board;
import dbAccess.BoardQueries;

public class BoardCTRL {
	private Board board;
	public BoardCTRL(Board board){
		this.board = board;
	}
	public void addBoard(){
		BoardQueries query = new BoardQueries(board);
		query.addBoard();
	}
	public void removeBoard(){
		BoardQueries query = new BoardQueries(board);
		query.removeBoard();
	}
	

}
