package rest;

import controllers.Device;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.ParseConversionEvent;
import org.json.simple.JSONObject;
import com.sun.xml.internal.ws.api.message.Message;


@Path("/device")
public class DeviceCTRLService {
	private Device Device;
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public String receiveDevice() {
		//receive device data and save in database *registeration process*
		
		
	   // String input = (String) inputJsonObj.get("name");
	   // String psswd = (String) inputJsonObj.get("password");
	    //String output = "The input you sent is :" + input;
	    
	    //JSONObject outputJsonObj = new JSONObject();
	    
	    //outputJsonObj.put("output", output);

	    //return outputJsonObj;
		return "post success";
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
