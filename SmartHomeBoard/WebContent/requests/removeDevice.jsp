<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="org.json.simple.JSONArray"%>
<%@ page
	import="java.net.URI , 
javax.ws.rs.client.Client , 
javax.ws.rs.client.ClientBuilder , 
javax.ws.rs.client.WebTarget , 
javax.ws.rs.core.MediaType , 
javax.ws.rs.core.Response ,
javax.ws.rs.core.UriBuilder , 
org.glassfish.jersey.client.ClientConfig ,
controllers.UserCTRL,
org.json.simple.parser.*,org.json.simple.JSONObject,
org.json.simple.parser.JSONParser,
org.json.simple.parser.ParseException,
javax.persistence.*,
javax.ws.rs.client.Entity,
Entities.User"%>
<%	
	//loading the devices of the boards
	JSONObject body = new JSONObject();
	String boardID = request.getParameter("boardID").toString();
	String deviceID = request.getParameter("deviceID").toString();
	body.put("deviceID", deviceID);
	System.out.println(body.toJSONString());
	ClientConfig config1 = new ClientConfig();

	Client client = ClientBuilder.newClient(config1);

	WebTarget target = client
			.target(UriBuilder
					.fromUri(
							"http://localhost:8080/SmartHomeBoard/service/device/removeDevice")
					.build());
	Object obj = target
			.request()
			.accept(MediaType.APPLICATION_JSON)
			.post(Entity.entity(body.toJSONString(),
					MediaType.APPLICATION_JSON), String.class);
	String redirectURL = "http://localhost:8080/SmartHomeBoard/Devices.jsp?boardID="+request.getParameter("boardID").toString();
	response.sendRedirect(redirectURL);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>