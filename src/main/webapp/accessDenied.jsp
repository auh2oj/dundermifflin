<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Access Denied</title>
</head>
<body>

<h1 style="color:red">You are not authorized to view this page.</h1>
<a href="${pageContext.request.contextPath}/showEmployees.do"><img src="${pageContext.request.contextPath}/img/home.png"/>Back To Home Page</a> 

</body>
</html>