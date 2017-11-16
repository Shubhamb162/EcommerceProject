<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<form method="post" action="">	<!-- For Spring security we have to remove actions it will handle by itself-->
		<br> <br> <br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h1 style="text-align: center">Login</h1>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" name="username" id="email"
							placeholder="Enter EmailId"><!-- for spring security name should be username -->
					
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" name="password" id="password"
							placeholder="Enter password">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</div>
	</form>

</body>
</html>