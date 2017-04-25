
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
		JSONObject body = new JSONObject();
		body.put("deviceName", "TV");
		body.put("serialNumber", "2374648");
		body.put("portNumber", "2222");
		System.out.println(body.toJSONString());
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/SmartHomeBoard/service/device/register");
		String response = webResource.type(MediaType.APPLICATION_JSON)
					  .accept(MediaType.APPLICATION_JSON)
					  .post(new GenericType<String>(){},body.toJSONString());
		System.out.println(response);
	}
}
