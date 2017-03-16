<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<div>
	<h1>User Home Page </h1>
	
    	<p>Smart Home Board - HomePage <br>Smart Home Board is under construction  </p>
	
			<% if (session.getAttribute("userName") == null) { 
				 %>
    			<P>You are currently not signin <a href="SignIn.jsp">Login</a> Not yet a member? <a href="Signup.jsp">Signup</a> </P>
					<% } else { 
					String guestName = (String) session.getAttribute("userName");%>
    					<p> Welcome :<%=guestName %> </p>
    						<form action="LogOutServlet" method="post">
   						 		<input type="submit" value="Logout" />
							</form>
						<% } %>
	
			
</div>


</body>
</html>