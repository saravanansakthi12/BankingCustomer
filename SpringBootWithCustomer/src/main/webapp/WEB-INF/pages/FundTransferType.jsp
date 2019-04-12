<%@page import="com.main.model.SavingAccount"%>
<%@page import="com.main.model.CustomerRegistration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<%-- <div class="w3-container">

  <div class="w3-bar w3-light-grey">
    <a href="#" class="w3-bar-item w3-button">Welcome ${name}</a>

  
    <a href="accsummary" class="w3-bar-item w3-button">Account Summary  </a>
     <!-- <a href="#" class="w3-bar-item w3-button">Add  </a> -->
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
 <div class="panel panel-primary" style="width: 70%">
      <div class="panel-heading">Select FundTransferType</div>
      <div class="panel-body">
      <table class="table table-striped">
      <tr><td><a href="WBank">Same Bank</a> </td></tr>
      <tr><td> <a href="OBank">Other Bank</a></td></tr>
      </table>
      </div>
    </div>
</center>

</body>
</html>