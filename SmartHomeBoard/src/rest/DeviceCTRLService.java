package rest;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
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
	public static String registerDevice(String message) throws ParseException {
		//receive device data and save in database *registeration process*
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		System.out.println("http body parsed from string to json");
		//JSONObject jsonObj = new JSONObject();
		device = new Device(messageobj.get("deviceName").toString(),
							messageobj.get("serialNumber").toString(),
							Integer.parseInt(messageobj.get("portNumber").toString()));
		System.out.println("recived JSON object in body: "+message);
		DeviceCTRL ctrl = new DeviceCTRL(device);
		try{
			String response = ctrl.registerDevice();
			return response;
		}catch(Exception e){
			return e.getMessage(); 
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
	
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendCommand")
	public static String sendCommand(String message) throws UnknownHostException, SQLException, IOException, ParseException, ClassNotFoundException {
		//send command to a certain device with open port number
		System.out.println("message: " +message);
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject)parser.parse(message);
		System.out.println("http body parsed from string to json");
		device.setId(Integer.valueOf(messageobj.get("deviceID").toString()));
		JSONObject response = new JSONObject();
		String ack;
		DeviceCTRL control = new DeviceCTRL(device);
		ack = control.sendCommand(messageobj.get("command").toString());
		response.put("ack", ack);
		return response.toJSONString();
		
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
	
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getInfo")
	public static String getInfo(String message) throws ParseException { //get the device info by posting the device id	
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject)parser.parse(message);
		System.out.println("message: " +message);
		System.out.println("http body parsed from string to json");
		device = new Device();
		device.setId(Integer.valueOf(messageobj.get("deviceID").toString()));
		try{
			DeviceCTRL control = new DeviceCTRL(device);
			device = control.getInfo();
		}catch(Exception e){
			return e.getMessage();
		}
		JSONObject response = new JSONObject();
		response.put("deviceName", device.getName());
		response.put("deviceID", device.getId());
		response.put("portNumber", device.getPortNumber());
		response.put("IPAddress", device.getIpAddress());
		response.put("serialNumber", device.getSerialNumber());
		return response.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStatus/{id}")
	public static String getStatus(@PathParam("id") String id) throws UnknownHostException, SQLException, IOException, ClassNotFoundException {
		JSONObject response = new JSONObject();
		String status;
		device = new Device();
		device.setId(Integer.valueOf(id));
		DeviceCTRL control = new DeviceCTRL();
		status = control.getStatus();
		response.put("status", status);
		return response.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBoardDevices")
	public static String getBoardDevices(String message) throws SQLException, ParseException{
		JSONParser parser = new JSONParser();
		JSONObject messageobj = (JSONObject) parser.parse(message);
		System.out.println("message: "+messageobj.toJSONString());
		JSONArray devices = new JSONArray();
		ArrayList<JSONObject> deviceArray = new ArrayList<JSONObject>();
		device = new Device();
		device.setBoardID(Integer.valueOf(messageobj.get("boardID").toString()));
		DeviceCTRL c = new DeviceCTRL(device);
		deviceArray = c.getBoardDevices();
		int arraySize = deviceArray.size();
		for(int i = 0; i<arraySize; i++){
			devices.add(deviceArray.get(i));
		}
		if(arraySize == 0){
			return "no devices in this board";
		}else{
			return devices.toJSONString();
		}
	}
}
