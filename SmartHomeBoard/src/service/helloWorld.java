package service;

import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
@Path("/test")
public class helloWorld {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/fun")
	public String getMsg(String x) throws ParseException{
		JSONParser y = new JSONParser();
		JSONObject j = (JSONObject) y.parse(x);
		return j.get("title").toString();
	}

}
