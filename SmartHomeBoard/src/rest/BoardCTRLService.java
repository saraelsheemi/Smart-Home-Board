package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		message = message.replaceAll("^\"|\"$", "");
		message = message.replaceAll("\\\\", "");
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
	
}
