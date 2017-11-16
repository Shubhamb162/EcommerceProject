<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Items</title>
<style type="text/css">
.img-thumbnail {
	height: 400px;
	width: 300px;
}
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="image" value="${contextPath}/resources" />
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">

			<c:forEach items="${products}" var="product">
				<div class="col-sm-4">
					<a href="${contextPath}/displayProduct/${product.productId}"><img src="${image}/${product.productName}.jpg"
						class="img-thumbnail"/>
					<h4>${product.productName}</h4></a>
					<h3>${product.productPrice}</h3>
				</div>
				

			</c:forEach>

		</div>
	</div>
</body>
</html>