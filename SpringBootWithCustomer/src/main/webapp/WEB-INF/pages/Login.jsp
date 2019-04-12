<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<form:form name="form" action="login" modelAttribute="customer">
		<table class="table table-hover" align="center">
			<tr>
				<h1 align="center">Login</h1>
			</tr>
			<tr>
				<td>NAME :</td>
				<td><form:input path="userName" placeholder="Enter name" /></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><form:password path="password" placeholder="Enter password" /></td>
				<br>
			</tr>
			<tr>
			 <td><a href="/">Reset</td><td ><a onclick="form.submit()" href="#">Login</td>
			 </tr>
			 <tr>
			<td colspan="2" >NewUser ?<a  href="/Registration">Sign_Up</a></td>
			</tr>
		</table>
		
	</form:form>
	<c:if test="${error1!=null}">
	<c:out  value="${error1}"></c:out>
	</c:if> 
	
	
</body>
</html>