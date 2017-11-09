<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Items</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="image" value="${contextPath}/resources" />
	<div class="container">
		<div class="row">
	<div class="col-sm-6">
	<c:forEach items="${products}" var="product">
		<img src="${image}/${product.productName}.jpg" class="img-thumbnail" />
	</c:forEach>
	</div></div></div>
</body>
</html>