<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>SignUp</title></head>>
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
						<label for="firstname">FirstName</label> <input type="text"
							class="form-control" name="firstName" id="name"
							placeholder="Enter First Name" required="required">
					</div>
					<div class="form-group">
						<label for="lastName">LastName</label> <input type="text"
							class="form-control" name="lastName" id="lastName"
							placeholder="Enter Last Name">
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" name="emailId" id="email"
							placeholder="Enter EmailId">
					</div>
					<div class="form-group">
						<label for="mobileNo">Mobile No</label> <input type="text"
							class="form-control" name="mobileNo" id="mobileNo"
							placeholder="Enter Mobile Number">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" name="password" id="password"
							placeholder="Enter password">
					</div>
					<div class="form-group">
						<label for="confirmPassword">Confirm Password</label> <input
							type="password" class="form-control" name="confirmPassword"
							id="confirmPassword" placeholder="Confirm Password">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</div>
	</form:form>

</body>
</html>