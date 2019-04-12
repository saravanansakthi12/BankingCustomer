<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1 {
	color: blue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration Page</title>

<script>
	$(function() {

		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>
</head>
<body>
	<form:form action="CreateCustomer" modelAttribute="customer">
<h1 style="color: blue;">Customer Registration</h1>
		<table class="table table-striped">
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>DOB</td>
			</tr>
			<tr>
				<td><form:input path="firstName" /> <!-- <input type="text"> -->

				</td>
				<td><form:input path="lastName" /> <!-- <input type="text"> -->
				</td>
				<td><form:input path="dateOfBirth" id="datepicker" /> <!-- <input type="text"></td></tr> -->
			<tr>
				<td>Address Line 1</td>
				<td>Address Line 2</td>
				<td>City</td>
			</tr>
			<tr>
				<td><form:input path="addressLine1" /> <!-- <input type="text"> -->
				</td>
				<td><form:input path="addressLine2" /> <!-- <input type="text"> -->
				</td>
				<td><form:input path="city" /> <!-- <input type="text"> --></td>
			</tr>
			<tr>
				<td>State</td>
				<td>PinCode</td>
				<td>MobileNumber</td>
			</tr>
			<tr>
				<td><form:input path="state" /> <!-- <input type="text"> --></td>
				<td><form:input path="pincode" /> <!-- <input type="text"> -->
				</td>
				<td><form:input path="mobileNumber" /> <!-- <input type="text"> -->
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>AadharNo</td>
				<td>Pan</td>
			</tr>
			<tr>
				<td><form:input path="email" /> <!-- <input type="text"> --></td>
				<td><form:input path="aadhar" /> <!-- <input type="text"> --></td>
				<td><form:input path="pan" /> <!-- <input type="text"> --></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td>Password</td>
				<td>ConfirmPassword</td>
			</tr>
			<tr>
				<td><form:input path="userName" /> <!-- <input type="text"> -->
				</td>
				<td><form:password path="password" /> <!-- <input type="password "> -->
				</td>
				<td><form:password path="" /> <!-- <input type="password "> -->
				</td>
			</tr>
			<tr>
				<td>Date Of Birth Proof</td>
				<td><form:input type="file" path="dobProof" /> <!-- <input type="text"> -->
				</td>
				<td>Ex:Passport,Birth Certificate Upload only PDF,JPG,JPEG
					Documents</td>
			</tr>
			<tr>
				<td>Address Proof</td>
				<td><form:input type="file" path="addressProof" /> <!-- <input type="text"></td></tr> -->
				<td>Ex:License, Voter Id Upload only PDF,JPG,JPEG Documents</td>
			<tr>
				<td>Aadhar</td>
				<td><form:input type="file" path="aadharProof" /> <!-- <input type="text"> -->
				</td>
				<td>Upload only PDF,JPG,JPEG Documents</td>
			</tr>
			<tr>
				<td>Pan</td>
				<td><form:input type="file" path="panProof" /> <!-- <input type="text"> -->
				</td>
				<td>Upload only PDF,JPG,JPEG Documents</td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="Submit"> <input
					type="reset" value="Reset">
		</table>
	</form:form>
</body>
</html>
