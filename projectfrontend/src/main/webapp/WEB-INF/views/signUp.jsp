<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SignUp</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<form:form method="post" modelAttribute="customer"
		action="signUpProcess">
		<br>
		<br>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h1 style="text-align: center">Signup</h1>
					<div class="form-group">
						<label for="firstname">FirstName</label> <form:input type="text" path="firstName"
							class="form-control" name="firstName" id="name"
							placeholder="Enter First Name" required="true" pattern="[a-zA-Z]{4,12}"/>
					</div>
					<div class="form-group">
						<label for="lastName">LastName</label> <form:input type="text" path="lastName"
							class="form-control" name="lastName" id="lastName"
							placeholder="Enter Last Name" required="true" pattern="[a-zA-Z]{4,12}"/>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <form:input type="email" path="emailId"
							class="form-control" name="emailId" id="email"
							placeholder="Enter EmailId" required="true"/>
					</div>
					<div class="form-group">
						<label for="mobileNo">Mobile No</label> <form:input type="text" path="mobileNo"
							class="form-control" name="mobileNo" id="mobileNo"
							placeholder="Enter Mobile Number" required="true" pattern="[0-9]{10}"/>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <form:input type="password" 
							class="form-control" name="password" id="password" path="password"
							placeholder="Enter password" required="true" pattern="[a-zA-Z.]{6,10}"/>
					</div>
					<div class="form-group">
						<label for="confirmPassword">Confirm Password</label> <form:input 
							type="password" class="form-control" path="confirmPassword" name="confirmPassword"
							id="confirmPassword" placeholder="Confirm Password"/>
					</div>
					<form:input path="is_Active" value="TRUE" hidden="true"/>
					<form:input path="role" value="ROLE_CUSTOMER" hidden="true"/>
					
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</div>
	</form:form>

</body>
</html>