<%@page import="com.main.model.CustomerRegistration"%>
<%@page import="com.main.model.SavingAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="style.css" />

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<c:if test="${str=='IFSC No Needed'}">
<c:set value="sameFundTransfer" var="action"/>
</c:if>
<c:if test="${str=='IFSC  Needed'}">
<c:set value="otherFundTransfer" var="action"/>
</c:if>
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
<form:form action="${action}" modelAttribute="fundTransfer">
<center>
    <div class="panel panel-primary" style="width: 70%">
    <div class="panel-heading">Fund Transfer</div>
     <div class="panel-body">
     
     <table class="table table-striped" style="border-collapse: collapse">
				<tr>

					<td><form:label path="accId">
							From Account Number
						</form:label> <form:input path="accId" value="${account.accId}" class="form-control"></form:input></td>
				</tr>
				<tr>

					<td><form:label path="benName">
							Select Beneficiary
						</form:label> <form:select path="benName" class="form-control">
						<form:option value=" "></form:option>
						<c:forEach var="beneficiary" items="${list}">
						<c:if test="${beneficiary.ifsc== null}">
							<form:option value="${beneficiary.name}">${beneficiary.name}</form:option>
							</c:if>
						</c:forEach>
						</form:select></td>
				</tr>
				<tr>

					<td><form:label path="amount">
							Amount
						</form:label> <form:input path="amount"
							class="form-control" /></td>
				</tr>
				<tr>

					<td><form:label path="transferDescription">
							TransferDescription
						</form:label> <form:input path="transferDescription" class="form-control" /></td>
				</tr>
			
			<tr>
				<td><br>
					<button type="submit" class="btn btn-success">Submit</button></td>
			</tr>
    </table>
     
          </div>
     </div>
</center>
</form:form>


</body>
</html>