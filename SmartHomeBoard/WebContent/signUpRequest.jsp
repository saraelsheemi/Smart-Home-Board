<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
javax.ws.rs.client.Entity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name").toString();
String email = request.getParameter("email").toString();
String password = request.getParameter("password").toString();
String gender = request.getParameter("gender").toString();

JSONObject body = new JSONObject();
body.put("name", name);
body.put("gender", gender);
body.put("email", email);
body.put("password", password);
System.out.println(body.toJSONString());
ClientConfig config1 = new ClientConfig();

Client client = ClientBuilder.newClient(config1);

WebTarget target = client.target(UriBuilder.fromUri(
		"http://localhost:8080/SmartHomeBoard/service/user/signup").build());
Object obj = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(body.toJSONString(),MediaType.APPLICATION_JSON), String.class);
String redirectURL = "http://localhost:8080/SmartHomeBoard";
response.sendRedirect(redirectURL);
%>
</body>
</html>