<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "javax.ws.rs.core.MediaType,
	com.owlike.genson.stream.JsonType,
	com.sun.jersey.api.client.*,
	com.sun.jersey.api.client.Client,
	com.sun.jersey.api.client.GenericType,
	com.sun.jersey.api.client.WebResource,
	com.sun.jersey.core.spi.factory.MessageBodyFactory,
	org.json.simple.JSONObject,
	org.json.simple.parser.JSONParser,
	org.json.simple.parser.ParseException"
%>
<%String name = request.getParameter("name");
  String gender = request.getParameter("gender");
  String email = request.getParameter("email");
  String password = request.getParameter("passwprd");
  JSONObject body = new JSONObject();
  body.put("name", name);
  body.put("gender", gender);
  body.put("email", email);
  body.put("password", password);
  System.out.println(body.toJSONString());
  Client client = Client.create();
  WebResource webResource = client.resource("http://localhost:8080/SmartHomeBoard/service/user/signup");
  String response1 = webResource.type(MediaType.APPLICATION_JSON)
			  .accept(MediaType.APPLICATION_JSON)
			  .post(new GenericType<String>(){},body.toJSONString());
  System.out.println(response);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
		padding:0;
		marign:0;
		width : 100%;
		height :100%;
		background-color: white;
	}
	.banner {
		width: inherit;
		height: 50px;
		background-color: grey;
	}
	#user{
		position:absolute;
		float: right;
		color: white;
		font-size: 25px;
		font-weight: 700;
		right:2%;
		top: 5%;
		cursor: pointer;
	}
	#user:hover{
		color: black;
	}
	
</style>
</head>
<body>
<div class="banner">
	<label id="user"><%=name%></label>
</div>

</body>
</html>