<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Information</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<br>
	<br>
	<br>
	<br>
	<c:set var="images"
		value="${pageContext.request.contextPath}/resources" />
	<div class="container">
		<div class="row">

			<div class="col-sm-6">
				<h1 style="text-align: center;">${product.productName}</h1>
				<img src="${images}/${product.productName}.jpg"
					style="height: 300px;" />
			</div>
			<div class="col-sm-6">
				<br> <br>
				<h2>Product Descripion:</h2>
				<p>${product.productDesc}</p>
				<h2>Product Price:</h2>
				<p>${product.productPrice}</p>
				<div class="col-sm-5">
					<a
						href="${pageContext.request.contextPath}/customer/addToCart/${product.productId}"><button
							class="btn btn-warning">Add Cart</button></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>