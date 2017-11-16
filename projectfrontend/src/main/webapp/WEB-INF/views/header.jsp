<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BookStore</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.navbar-custom1 .nav>li>a:focus, .navbar-custom1 .nav>li>a:hover,
	.navbar-custom1 .nav>li.active>a {
	background-color: LightBlue;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom1">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}">BookLand</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<security:authorize access="!hasAuthority('ROLE_ADMIN')">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${categoryLists}" var="categoryList">
							<li><a
								href="${pageContext.request.contextPath}/categoryItems/${categoryList.categoryId}">${categoryList.categoryName}</a></li>
						</c:forEach>
					</ul></li>
					</security:authorize>
					<security:authorize access="hasAuthority('ROLE_ADMIN')">
				<li><a href="${pageContext.request.contextPath}/admin/productDisplay">Product</a></li>
			
				<li><a
					href="${pageContext.request.contextPath}/admin/categoryDisplay">Category</a></li>
	</security:authorize>
	
			</ul>
			<security:authorize access="isAnonymous()">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/signUp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/logout"><span
						class="glyphicon glyphicon-user"></span>Logout</a></li>
				
			</ul>
			</security:authorize>
		</div>
	</nav>