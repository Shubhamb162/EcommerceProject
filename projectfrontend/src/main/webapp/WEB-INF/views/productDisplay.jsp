<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style type="text/css">
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
}
th{
	text-align:center;
	}
td {
    text-align: center;
}
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%-- <form:form method="post" modelAttribute="customer"
		action="registerProcess">
		<br>
		<br>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h1 style="text-align: center">Products</h1>
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
						<label for="password">Password</label> <input type="text"
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
	 --%>
	<form:form action="productProcess" modelAttribute="product"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="productName">Product Name</form:label></td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td><form:label path="productDesc">Product Description</form:label></td>
				<td><form:input path="productDesc" /></td>
			</tr>
			<tr>
				<td><form:label path="productPrice">Product Price</form:label></td>
				<td><form:input path="productPrice" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
	<br>
	<br>
	<table align="center" style="width: 80%">
		<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Price</th>
		</tr>
		<c:forEach var="products" items="${productLists}">
			<tr>
				<td>${products.productName}</td>
				<td>${products.productDesc}</td>
				<td>${products.productPrice}</td>
		</c:forEach>
	</table>
</body>
</html>