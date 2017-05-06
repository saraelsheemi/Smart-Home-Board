package src;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.persistence.*;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;

public class Registeration {

	@SuppressWarnings("unchecked")
	public static void register() {
		JSONObject body = new JSONObject();
		body.put("deviceName", "TV");
		body.put("serialNumber", "2374648");
		body.put("portNumber", "2222");
		System.out.println(body.toString());
		ClientConfig config1 = new ClientConfig();

		Client client = ClientBuilder.newClient(config1);

		WebTarget target = client.target(UriBuilder.fromUri(
				"http://localhost:8080/SmartHomeBoard/service/device/register")
				.build());
		Object obj = target
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(body.toJSONString(),
						MediaType.APPLICATION_JSON), String.class);
		System.out.println("requst sent");
		JSONObject response = (JSONObject) obj;
		//System.out.println("response"+response.toJSONString());
		JOptionPane.showMessageDialog(null, response.toString());

	}
}
