package rest;

import controllers.Device;

import java.io.BufferedReader;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.ParseConversionEvent;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@Path("/device")
public class DeviceCTRLService {
	private Device Device;
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/fun")
	public String getMsg(String x) throws ParseException{
		JSONParser y = new JSONParser();
		JSONObject j = (JSONObject) y.parse(x);
		return j.get("title").toString();
	}


	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/register")
	public static String receiveDevice(String message) throws Exception {
		//receive device data and save in database *registeration process*
        // u need to check how to get the http request inside this function.
		return message;
	}
	
	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void removeDevice() {
		//remove device from database 
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void addDevice() {
		//add device to user board 
	}
	
	@POST
	@Path("/sendCommand")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void sendCommand() {
		//send command to a certain device with open port number
	}
	@POST
	@Path("/enableNotification")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void enableNotification() {
		//enable notification to a certain device
	}
	@POST
	@Path("/disableNotification")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void disableNotification() {
	}
	
	@POST
	@Path("/pullNotification")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void pullNotification() {
	}
	
	@POST
	@Path("/getInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void getInfo() {
	}
	
	@GET
	@Path("/getStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public static String getStatus() {
		JSONObject object = new JSONObject();
		object.put("Account", "Created");
		return object.toJSONString();
		
	}

}
