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
	//loading the boards of the user
	JSONObject body = new JSONObject();
	body.put("userID", session.getAttribute("userId").toString());
	System.out.println(body.toJSONString());
	ClientConfig config1 = new ClientConfig();

	Client client = ClientBuilder.newClient(config1);

	WebTarget target = client
			.target(UriBuilder
					.fromUri(
							"http://localhost:8080/SmartHomeBoard/service/board/getboards")
					.build());
	Object obj = target
			.request()
			.accept(MediaType.APPLICATION_JSON)
			.post(Entity.entity(body.toJSONString(),
					MediaType.APPLICATION_JSON), String.class);
	JSONArray boards;
	try{
		JSONParser parser = new JSONParser();
		boards = (JSONArray) parser.parse(obj.toString());
	}catch(Exception e){
		boards = new JSONArray();
		//JSONObject board = new JSONObject();
		//boards.add(0, board);
	}
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
				<a class="navbar-brand" href="userHomePage.jsp">Smart Home Board</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="userHomePage.jsp">Home</a></li>
					<li><a href="boards.jsp">Boards</a></li>
					<li><a href="#contact">Contact</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="requests/signoutHandler.jsp">Log out</a></li>
				</ul>
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
						int size = boards.size();
						if(size == 0){
							%><li> No Boards Found </li><% 
						}else{
						for (int i = 0; i < size; i++) {
						JSONObject board = (JSONObject) boards.get(i);
					%>
					<li role="presentation" class="active">
					<a href=<%= "\"Devices.jsp?boardID="+board.get("boardID").toString()+"\""%> id=<%= board.get("boardID").toString()%>  style="background: #618793; width: 200px; height: 210px; margin: 10px; border: medium none; display: block; float: left; outline: medium none; padding: 8px 16px"> <%=board.get("boardName").toString()%></a></li>
					<%
						}
					}
					%>
				</ul>
				<p>Need extra board?</p>
				<form method="POST" action="requests/addBoard.jsp">
  					Board Name:<br><input type="text" name="boardName"><br>
  					<input type="submit" value="add board">
				</form>
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