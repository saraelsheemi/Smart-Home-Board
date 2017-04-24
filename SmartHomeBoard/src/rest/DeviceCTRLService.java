package rest;

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

import Entities.Device;
import controllers.DeviceCTRL;



@Path("/device")
public class DeviceCTRLService {
	private static Device device;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public static String registerDevice(String message) throws Exception {
		//receive device data and save in database *registeration process*
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		device = new Device(messageobj.get("deviceName").toString(),
							messageobj.get("serialNumber").toString(),
							Integer.parseInt(messageobj.get("portNumber").toString()));
		DeviceCTRL ctrl = new DeviceCTRL(device);
		try{
		ctrl.registerDevice();
		System.out.println("device registerd");
		return "device regesterd succesfully";
		}catch(Exception e){
			return "failed"; //e.getStackTrace().toString();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remove")
	public static void removeDevice() {
		//remove device from database 
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public static void addDevice() {
		//add device to user board 
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendCommand")
	public static void sendCommand() {
		//send command to a certain device with open port number
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/enableNotification")
	public static void enableNotification() {
		//enable notification to a certain device
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/disableNotification")
	public static void disableNotification() {
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pullNotification")
	public static void pullNotification() {
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getInfo")
	public static void getInfo() {
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStatus")
	public static String getStatus() {
		JSONObject object = new JSONObject();
		object.put("Account", "Created");
		return object.toJSONString();
		
	}

}
