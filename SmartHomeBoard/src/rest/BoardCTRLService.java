package rest;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Entities.Board;
import controllers.BoardCTRL;

@Path("/board")
public class BoardCTRLService {
	private static Board board;
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public static String addBoard(String message) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		board = new Board(messageobj.get("boardName").toString());
		board.setOwnerId(Integer.valueOf(messageobj.get("userID").toString()));
		BoardCTRL ctrl = new BoardCTRL(board);
		try{
			ctrl.addBoard();
			return "Board added successfully";
		}catch(Exception e){
			return e.getMessage();
		}
		
		
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remove")
	public static String removeBoard(String message) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		board = new Board(Integer.parseInt(messageobj.get("boardID").toString()));
		BoardCTRL ctrl = new BoardCTRL(board);
		try{
			ctrl.removeBoard();
			return "Board removed successfully";
		}catch(Exception e){
			return e.getMessage();
		}
		
	}
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getboards")
	public static String getUserBoards(String message) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		System.out.println("message: "+ messageobj.toJSONString());
		board = new Board();
		board.setOwnerId(Integer.valueOf(messageobj.get("userID").toString()));
		JSONArray boards = new JSONArray();
		ArrayList<JSONObject> boardArray = new JSONArray();
		BoardCTRL ctrl = new BoardCTRL(board);
		try{
			boardArray = ctrl.getUserBoards();
			int arraySize = boardArray.size();
			for(int i = 0; i<arraySize; i++){
				boards.add(boardArray.get(i));
			}
			return boards.toJSONString();
		}catch(Exception e){
			return e.getMessage();
		}
	}
}
