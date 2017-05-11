package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import security.AESencrp;
import Entities.User;
import controllers.UserCTRL;

@Path("/user")
public class UserCTRLService {
	public static User user;

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signin")
	public static String signIn(String message) throws Exception {
		System.out.println("message: " + message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		String password = AESencrp.decrypt(messageobj.get("password").toString());
		user = new User(messageobj.get("email").toString(), password);
		UserCTRL ctrl = new UserCTRL(user);
		JSONObject responseBody = new JSONObject();
		try {
			user = ctrl.signIn();
			responseBody.put("userName", user.getName());
			responseBody.put("userID", user.getId());
		} catch (Exception e) {
			e.getMessage();
			responseBody.put("userName", "null");
			responseBody.put("userID", "null");
		}
		return responseBody.toJSONString();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signup")
	public static void signUp(String message) throws Exception {
		System.out.println("message: " + message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		String password = AESencrp.decrypt(messageobj.get("password").toString());
		user = new User(messageobj.get("name").toString(), "admin", messageobj.get("gender").toString(),
				messageobj.get("email").toString(), password);
		UserCTRL ctrl = new UserCTRL(user);
		try {
			ctrl.signUp();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adduser")
	public static void addUser(String message) throws ParseException {
		System.out.println("message: " + message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(Integer.valueOf(messageobj.get("userID").toString()));
		UserCTRL ctrl = new UserCTRL(user);
		try {
			ctrl.addUser(Integer.valueOf(messageobj.get("boardID").toString()));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeuser")
	public static void removeUser(String message) throws ParseException {
		System.out.println("message: " + message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(Integer.valueOf(messageobj.get("id").toString()));
		UserCTRL ctrl = new UserCTRL(user);
		try {
			ctrl.removeUser(Integer.valueOf(messageobj.get("boardID").toString()));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteaccount")
	public static void deleteAccount(String message) throws ParseException {
		System.out.println("message: " + message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		user = new User(Integer.valueOf(messageobj.get("id").toString()));
		UserCTRL ctrl = new UserCTRL(user);
		try {
			ctrl.deleteAccount();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
