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
<form name="loginForm" method="POST" action="">
<p>First name: <input type="text" name="firstName" /> </p>
<p>Last name : <input type="text" name="lastName" /> </p>
<p>Password  : <input type="password" name="password" /> </p>
<p>Email     : <input type="text" name="email" /> </p>
<p>Country   : <input type="text" name="country" /> </p>
<button name="SignupButton" type="submit">Sign up </button>
</form>

<p><a href="Homepage.jsp">Back</a> </p>
</div>
</body>
</html>