<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<h3>Login Form</h3>
	<hr />
	<form name="loginForm" method="POST" action="requests/signUpRequest.jsp">
		<p>
			Name: <input type="text" name="name" />
		</p>
		<p>
			Gender : <input type="text" name="gender" />
		</p>
		<p>
			Email : <input type="text" name="email" />
		</p>
		<p>
			Password : <input type="password" name="password" />
		</p>
		<button name="SignupButton" type="submit">Sign up</button>
	</form>
	<p>
		<a href="Home-page.jsp">Back</a>
	</p>
	</div>
</body>
</html>