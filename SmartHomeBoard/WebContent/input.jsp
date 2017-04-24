<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="loginForm" method="POST" action="service/test/fun" class="navbar-form navbar-right" enctype='application/json'>
            <div class="form-group">
              <input type="text" placeholder="Email" name="username" class="form-control" enctype="APPLICATION_JSON" >
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password"  class="form-control">
            </div>
           <button type="submit" class="btn btn-success">Sign in</button>
            
          </form>
</body>
</html>