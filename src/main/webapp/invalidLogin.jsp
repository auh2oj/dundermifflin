<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invalid Login</title>
</head>
<body>

<img alt="" src="${pageContext.request.contextPath}/img/login.png" height="150px;" style="margin: 20px">
    <label style="color:blue"><img alt="" src="${pageContext.request.contextPath}/img/result.png" height="100px;">
    </label>
    <h1 style="color:red">Incorrect username or password.</h1>
    <a href="${pageContext.request.contextPath}/login.jsp">Click here to try again.</a>

</body>
</html>