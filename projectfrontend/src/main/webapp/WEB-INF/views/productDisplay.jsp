<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Display</title>
<style type="text/css">
/* table,th {
	text-align: center;
}
 */
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<form:form action="${pageContext.request.contextPath}/admin/productProcess"
		modelAttribute="product" method="post" enctype="multipart/form-data">
		<br>
		<br>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h1 style="text-align: center">Add Product</h1>
					<form:input type="hidden" path="productId" />
					<div class="form-group">
						<label for="productName">Product Name</label>
						<form:input type="text" path="productName" class="form-control"
							name="productName" id="productName"
							placeholder="Enter Product Name" required="required" />
					</div>
					<div class="form-group">
						<label for="productDesc">Product Description</label>
						<form:input path="productDesc" type="text" class="form-control"
							name="productDesc" id="productDesc"
							placeholder="Enter product Description" />
					</div>
					<div class="form-group">
						<label for="productPrice">Product Price</label>
						<form:input path="productPrice" type="number" class="form-control"
							name="productPrice" id="productPrice"
							placeholder="Enter product Price" />
					</div>
					<div class="form-group">
						<label for="productImage">Product Image</label>
						<form:input type="file" path="productImage" />
					</div>
					<div class="form-group">
						<label for="productStock">Product Stock</label>
						<form:input path="productStock" type="number" class="form-control"
							name="productStock" id="productStock"
							placeholder="Enter product Stock" />
					</div>
					<div class="form-group">
						<label for="sel1">Select Category:</label>
						<form:select class="form-control" id="sel1"
							path="category.categoryId">
							<c:forEach var="category" items="${categoryLists}">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
						</form:select>
					</div>
					<div>
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<div class="container">
		<h2 style="text-align: center">Product List</h2>
		<table class="table table-bordered" style="text-align: center;">
			<thead>
				<tr>
					<!--<th style="text-align: center;"><span class="glyphicons glyphicons-picture"></span></th>-->
					<!-- <th style="text-align: center;">Product Address</th> -->
					<th style="text-align: center;">Product Name</th>
					<th style="text-align: center;">Product Description</th>
					<th style="text-align: center;">Product Price</th>
					<th style="text-align: center;">Product Stock</th>
					<th style="text-align: center;">Edit / Delete</th>
				</tr>
			</thead>
			<c:forEach var="products" items="${productLists}">
				<tr>
					<%-- <td>${products.productId}</td> --%>
					<td><a href="${pageContext.request.contextPath}/productInformation/${products.productId}">${products.productName}</a></td>
					<td>${products.productDesc}</td>
					<td>${products.productPrice}</td>
					<td>${products.productStock}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/editProduct/${products.productId}"><button
								type="button" class="btn btn-primary">Edit</button></a><a
						href="${pageContext.request.contextPath}/admin/deleteProduct/${products.productId}">
							<button type="button" class="btn btn-danger">Delete</button>
					</a></td>
			</c:forEach>
		</table>
	</div>
</body>
</html>