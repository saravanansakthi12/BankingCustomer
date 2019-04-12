<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
     
<title>AccountSummary</title>

</head>
<body>

<%-- <nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<h3>Hello <%=username %></h3>
</div>
<ul class="nav navbar-nav navbar-right">
      <li><a href="/loginPage"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
</ul>
</div>
</nav>
<div class="container-fluid">
<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Savings Accounts
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="#">create Savings account</a></li>
  </ul>
</div>
</div> --%>
<nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<h3>Welcome ${name} </h3>
</div>
<ul class="nav navbar-nav navbar-right">
      <li><a href="/"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
</ul>
</div>
</nav>


<!-- <div class="container"> -->
  <div class="panel panel-default">
    <div class="panel-heading">
    <h3>Account Summary</h3>
    </div>
    <div class="panel-body">
    <div class="btn-group">
    <div class="btn-group">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Account
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
<c:if test="${savingAccount1==null}">
  
  <li><a href="./create">create Savings Account</a></li>
  </c:if>
  <c:if test="${savingAccount1!=null}">
   <li><a href="#">create Term Account</a></li>
  </c:if>
   
  </ul>
</div>
<div class="btn-group">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Fund Transfer
  <span class="caret"></span></button>
  <c:if test="${savingAccount1!=null}">
  <ul class="dropdown-menu">
    
    <li><a href="./addBeneficiary">Add Beneficiary</a></li>
    <li><a href="./selectBank">Fund Transfer</a></li>
    
  </ul>
  </c:if>
</div>
<div class="btn-group">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Others
  <span class="caret"></span></button>
  <c:if test="${savingAccount1!=null}">
  <ul class="dropdown-menu">
  
    <li><a href="#">Check Book Request</a></li>
    
  </ul>
  </c:if>
</div>
    </div>
    <c:if test="${savingAccount1!=null}">
    <table class="table">
    <tr>
    <th>Account Number</th>
    <th>Account Type</th>
    <th>Account Balance</th>
    <th>Created Date</th>
    <th>Updated Date</th>
    </tr>
    <tr>
    <td>${savingAccount1.accId}</td>
    <td>${savingAccount1.accType}</td>
    <td>${savingAccount1.accBalance}</td>
    <td>${savingAccount1.createdDate}</td>
    <td>${savingAccount1.updatedDate}</td>
    </tr>
    
    
    </table>
    </c:if>
    </div> 
    
  </div>
<!-- </div> -->

</body>
</html>
