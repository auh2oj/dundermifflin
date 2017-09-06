<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Stub</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 


</head>
<body>
	<img alt="" src="img/login.png" height="150px;" style="margin: 20px">
	<hr/>
	
    <div style="margin-left: 30px;">
    <form action="auth-user.do" method="post">
        <div class="form-group">
            <label>Username:</label>
            <input type="text" class="form-control"  name="username" placeholder="Username" style="width: 300px;"/>
        </div>

	<div class="form-group">
            <label>Password:</label>
            <input type="password" class="form-control"  name="password" placeholder="password" style="width: 300px;"/>
        </div>
                
        <button type="submit" class="btn btn-danger">Login</button>
    </form>
    <br/><br/>
    <span style="color: red;font-size: 16px;">${param.message}</span>
    <label style="color:blue"><img alt="" src="img/result.png" height="100px;">
    </div>
</body>
</html>