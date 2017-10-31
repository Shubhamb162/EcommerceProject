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
/* table,th {
	text-align: center;
}
 */</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<form:form action="productProcess" modelAttribute="product"
		method="post">
		<br>
		<br>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h1 style="text-align: center">Products</h1>
					<div class="form-group">
						<label for="productName">Product Name</label> <input type="text"
							class="form-control" name="productName" id="productName"
							placeholder="Enter Product Name" required="required">
					</div>
					<div class="form-group">
						<label for="productDesc">Product Description</label> <input
							type="text" class="form-control" name="productDesc"
							id="productDesc" placeholder="Enter product Description">
					</div>
					<div class="form-group">
						<label for="productPrice">Product Price</label> <input
							type="number" class="form-control" name="productPrice"
							id="productPrice" placeholder="Enter product Price">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</div>
	</form:form>
	
	<div class="container">
		<h2 style="text-align: center">Product List</h2>
		<table class="table table-bordered" style="text-align: center;">
			<thead>
				<tr>
					<th style="text-align: center;">Product Name</th>
					<th style="text-align: center;">Product Description</th>
					<th style="text-align: center;">Product Price</th>
				</tr>
			</thead>
			<c:forEach var="products" items="${productLists}">
				<tr>
					<td>${products.productName}</td>
					<td>${products.productDesc}</td>
					<td>${products.productPrice}</td>
			</c:forEach>
		</table>
	</div>
</body>
</html>