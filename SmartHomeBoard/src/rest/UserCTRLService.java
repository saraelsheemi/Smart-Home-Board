package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Entities.User;
import controllers.UserCTRL;

@Path("/user")
public class UserCTRLService {
	public static User user;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signin")
	public static void signIn(String message) throws ParseException{
		System.out.println("message: " +message);
		message = message.replaceAll("^\"|\"$", "");
		message = message.replaceAll("\\\\", "");
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(messageobj.get("email").toString(),messageobj.get("password").toString());
		UserCTRL ctrl = new UserCTRL(user);
		try{
			ctrl.signIn();
		}catch(Exception e){
			e.getMessage();
		}
	}
	public static void SignOut(){}// the sign out method doesn't have anything to do with the backend 
	  							  // it just should remove the user and his info from the session
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signup")
	public static void signUp(String message) throws ParseException{
		System.out.println("message: " +message);
		message = message.replaceAll("^\"|\"$", "");
		message = message.replaceAll("\\\\", "");
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(/*fill the user data*/);
		UserCTRL ctrl = new UserCTRL(user);
		try{
			ctrl.signUp();
		}catch(Exception e){
			e.getMessage();
		}
	} 
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adduser")
	public static void addUser(String message) throws ParseException{
		System.out.println("message: " +message);
		message = message.replaceAll("^\"|\"$", "");
		message = message.replaceAll("\\\\", "");
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(/*fill the user data*/);
		UserCTRL ctrl = new UserCTRL(user);
		try{
			ctrl.addUser();
		}catch(Exception e){
			e.getMessage();
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeuser")
	public static void removeUser(String message) throws ParseException{
		System.out.println("message: " +message);
		message = message.replaceAll("^\"|\"$", "");
		message = message.replaceAll("\\\\", "");
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(/*fill the user data*/);
		UserCTRL ctrl = new UserCTRL(user);
		try{
			ctrl.removeUser();
		}catch(Exception e){
			e.getMessage();
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteaccount")
	public static void deleteAccount(String message) throws ParseException{
		System.out.println("message: " +message);
		message = message.replaceAll("^\"|\"$", "");
		message = message.replaceAll("\\\\", "");
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(/*fill the user data*/);
		UserCTRL ctrl = new UserCTRL(user);
		try{
			ctrl.deleteAccount();
		}catch(Exception e){
			e.getMessage();
		}
	}
	
}
