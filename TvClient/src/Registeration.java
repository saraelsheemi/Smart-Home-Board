
import javax.ws.rs.core.MediaType;

import com.owlike.genson.stream.JsonType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.spi.factory.MessageBodyFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Registeration {
	
	@SuppressWarnings("unchecked")
	public static void register(){
<<<<<<< HEAD
	JSONObject body = new JSONObject();
	body.put("deviceName", "TV");
	body.put("serialNumber", "2374648");
	body.put("portNumber", "2222");
	System.out.println(body.toString());
	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/SmartHomeBoard/service/device/register");
	String response = webResource.type(MediaType.APPLICATION_JSON)
=======
		JSONObject body = new JSONObject();
		body.put("deviceName", "TV");
		body.put("serialNumber", "2374648");
		body.put("portNumber", "2222");
		System.out.println(body.toJSONString());
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/SmartHomeBoard/service/device/register");
		String response = webResource.type(MediaType.APPLICATION_JSON)
>>>>>>> b7db6bc54abaef7f4ff3f0dd3f71ee0ceb8aeb11
					  .accept(MediaType.APPLICATION_JSON)
					  .post(new GenericType<String>(){},body.toJSONString());
		System.out.println(response);
	}
}
