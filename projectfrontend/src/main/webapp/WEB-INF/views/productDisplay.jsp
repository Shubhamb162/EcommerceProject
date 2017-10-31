<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
    border: 1px solid black;
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
	<form:form action="productProcess" modelAttribute="product" method="post">
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
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
	<br>
	<br>
	<table align="center" padding="10px">
		<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Price</th>
		</tr>
		
		<c:forEach  var="products" items="${productLists}">
		<tr>
		<td>${products.productName}</td>
		<td>${products.productDesc}</td>
		<td>${products.productPrice}</td>
		</c:forEach>
		
	</table>
</body>
</html>