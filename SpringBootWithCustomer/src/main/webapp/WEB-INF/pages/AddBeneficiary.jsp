<%@page import="com.main.model.SavingAccount"%>
<%@page import="com.main.model.CustomerRegistration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Beneficiary</title>
</head>
<body>
<c:if test="${str=='IFSC No Needed'}">
<c:set value="sameBank" var="action"/>
</c:if>
<c:if test="${str=='IFSC  Needed'}">
<c:set value="otherBank" var="action"/>
</c:if>
<form:form action="${action}" modelAttribute="beneficiary">

<%-- <div class="w3-container">

  <div class="w3-bar w3-light-grey">
    <a href="#" class="w3-bar-item w3-button">Welcome ${name}</a>

  
    <a href="../accsummary" class="w3-bar-item w3-button">Account Summary  </a>
 <!--     <a href="#" class="w3-bar-item w3-button">Add  </a> -->
     <ul class="nav navbar-nav navbar-right">
      <li><a href="/"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
</ul>
  </div>
</div> --%>
<%
CustomerRegistration customer1 = (CustomerRegistration) session.getAttribute("customer");
SavingAccount account = (SavingAccount) session.getAttribute("account");
/* out.print(account.getAccId()); */
%>
<nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<h3>Welcome <%=customer1.getFirstName()+" "+customer1.getLastName() %> </h3>
</div>
<ul class="nav navbar-nav navbar-right">
      <li><a href="/"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
</ul>
</div>
</nav>
<center>
 <div class="panel panel-primary" style="width: 70%" style="height: 70%" >
      <div class="panel-heading">Beneficiary Details</div>
      <table class="table table-striped">
      <tr><td>Name</td><td> <form:input  path="name"/></td></tr>
<tr><td>Account Number </td><td><form:input  path="accNumber"/></td></tr>
<tr><td>E-Mail </td><td><form:input  path="eMail"/></td></tr>
<c:if test="${str=='IFSC  Needed'}">
<tr><td>IFSC </td><td><form:input  path="ifsc"/></td></tr>
</c:if>
<tr><td>Remarks</td><td> <form:input  path="remarks"/></td></tr>
<tr><td> <input type="submit" value="Submit"/></td></tr>
</table>
    </div>
    </center>
    </form:form>
</body>
</html>