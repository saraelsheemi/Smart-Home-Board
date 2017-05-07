package src;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONObject;
import javax.ws.rs.client.Entity;

public class Registeration {
	
	@SuppressWarnings("unchecked")
	public String register() {
		TV tv = new TV();
		JSONObject body = new JSONObject();
		body.put("deviceName", "TV");
		body.put("serialNumber", "125");
		body.put("portNumber", String.valueOf(tv.getPort()));
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
		String response = (String) obj;
		return response;

	}
}
