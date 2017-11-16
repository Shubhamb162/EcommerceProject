<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Display</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<form:form action="${pageContext.request.contextPath}/admin/categoryProcess" modelAttribute="category"
		method="post">
		<br>
		<br>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h1 style="text-align: center">Add Category</h1>
					<form:input type="hidden" path="categoryId" />
					<div class="form-group">
						<label for="categoryName">Category Name</label>
						<form:input type="text" path="categoryName" class="form-control"
							name="categoryName" id="categoryName"
							placeholder="Enter category Name" required="required" />
					</div>
					<div class="form-group">
						<label for="categoryDesc">Category Description</label>
						<form:input path="categoryDesc" type="text" class="form-control"
							name="categoryDesc" id="categoryDesc"
							placeholder="Enter category Description" />
						<div>
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<div class="container">
		<h2 style="text-align: center">Category List</h2>
		<table class="table table-bordered" style="text-align: center;">
			<thead>
				<tr>
					<!--<th style="text-align: center;"><span class="glyphicons glyphicons-picture"></span></th>-->
					<th style="text-align: center;">Category Name</th>
					<th style="text-align: center;">Category Description</th>
					<th style="text-align: center;">Edit/Delete</th>
					</tr>
			</thead>
			<c:forEach var="category" items="${categoryLists}">
				<tr>
					<td>${category.categoryName}</td>
					<td>${category.categoryDesc}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/editCategory/${category.categoryId}"><button
								type="button" class="btn btn-primary">Edit</button></a><a
						href="${pageContext.request.contextPath}/admin/deleteCategory/${category.categoryId}">
							<button type="button" class="btn btn-danger">Delete</button>
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>