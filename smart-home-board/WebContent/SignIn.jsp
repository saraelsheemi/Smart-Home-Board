<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<h3>Login Form</h3>
<hr/>
<div>
<form name="loginForm" method="POST" action="SignInServlet">
<p>User name : <input type="text" name="username" /> </p>
<p>Password : <input type="password" name="password" /> </p>
<button name="loginButton" type="submit">Sign in</button>
</form>

<div class="checkbox">
    <label>
	
      <input name ="remember" type="checkbox"> Remember Me
	  
    </label>
	
</div>
  
  <a href ="forgot-password.jsp"> Forget Password </a>

<p><a href="Homepage.jsp">Back</a> </p>
</div>
</body>
</html>