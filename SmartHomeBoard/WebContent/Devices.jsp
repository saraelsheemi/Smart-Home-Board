<!DOCTYPE html>
<%@page import="org.json.simple.JSONArray"%>
<html lang="en">
<head>
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
	body.put("boardID", boardID);
	System.out.println(body.toJSONString());
	ClientConfig config1 = new ClientConfig();

	Client client = ClientBuilder.newClient(config1);

	WebTarget target = client
			.target(UriBuilder
					.fromUri(
							"http://localhost:8080/SmartHomeBoard/service/device/getBoardDevices")
					.build());
	Object obj = target
			.request()
			.accept(MediaType.APPLICATION_JSON)
			.post(Entity.entity(body.toJSONString(),
					MediaType.APPLICATION_JSON), String.class);
	JSONParser parser = new JSONParser();
	JSONArray devices = (JSONArray) parser.parse(obj.toString());
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Smart Home Board</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Smart Home Board</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="Home-page.jsp">Home</a></li>
					<li><a href="#contact">tabs Menu</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<div class="belownav">
		<div class="container">

			<div>
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<%
						int size = devices.size();
						for (int i = 0; i < size; i++) {
						JSONObject device = (JSONObject) devices.get(i);
					%>
					<li role="presentation" class="active">
					<a href=<%= "\"Devices.jsp?boardID="+device.get("deviceID").toString()+"\""%> id=<%= device.get("deviceID").toString()%>  style="background: #618793; width: 200px; height: 210px; margin: 10px; border: medium none; display: block; float: left; outline: medium none; padding: 8px 16px"> <%=device.get("deviceName").toString()%></a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>