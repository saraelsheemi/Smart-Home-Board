<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	if (request.getSession(false) == null) {
	} else {
		String username = String.valueOf(session.getAttribute("username"));
		if (!username.equals("null")) {
			String redirectURL = "http://localhost:8080/SmartHomeBoard/userHomePage.jsp";
			response.sendRedirect(redirectURL);
		}
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Smart Home Board</a>
        </div>       
         <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
         
            <li><a href="# ">About</a></li>
            <li><a href="#">Contact</a></li>
            
          
          </ul>
          <form name="loginForm" method="POST" action="requests/signInRequest.jsp" class="navbar-form navbar-right" enctype='application/json'>
            <div class="form-group">
              <input type="email" placeholder="Email" name="email" class="form-control" enctype="APPLICATION_JSON" required >
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password"  class="form-control" required>
            </div>
           <button type="submit" class="btn btn-success">Sign in</button>
            
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
    <div class="jumbotron">
      <div class="container">
        <div class="row">
          <div class ="col-md-6">
          	
			<h1> Hello <span class="word"> users! </span></h1>
            <p> <span class="word"> Welcome to the smart home board control website You are currently not signin Not yet a member? <a href="signUp-ui.jsp">Signup </span></a></p>
            <p><a class="btn btn-primary btn-lg id="button" href ="#" role ="button"> Learn More </a></p>
           			 </div>
           		</div>
            </div>
            </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>