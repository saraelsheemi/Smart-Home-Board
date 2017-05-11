<%@page import="security.AESencrp"%>
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
javax.ws.rs.client.Entity,
Entities.User"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();

		JSONObject body = new JSONObject();
		body.put("email", email);
		password = AESencrp.encrypt(password);
		body.put("password", password);
		System.out.println(body.toJSONString());
		ClientConfig config1 = new ClientConfig();

		Client client = ClientBuilder.newClient(config1);

		WebTarget target = client.target(UriBuilder.fromUri(
				"http://localhost:8080/SmartHomeBoard/service/user/signin")
				.build());
		Object obj = target
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(body.toJSONString(),
						MediaType.APPLICATION_JSON), String.class);
		System.out.println("obj: : "+obj.toString());
		JSONObject userTemp = new JSONObject();
		JSONParser parser = new JSONParser();
		JSONObject userobj = (JSONObject) parser.parse(obj.toString());
		System.out.println("userdata: "+userobj.toJSONString());
		if(userobj.get("userName") != "null"){
			session.setAttribute( "username", userobj.get("userName").toString());
			session.setAttribute( "userId", userobj.get("userID").toString());
		}else{
			out.println("<html> user not found </html>");
		}
		
		   
		String redirectURL = "http://localhost:8080/SmartHomeBoard/userHomePage.jsp";
		response.sendRedirect(redirectURL);
	%>
</body>
</html>