<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<br>
	<br>
	<br>
	<div class="container">
		<h1 style="text-align: center;">Invoice</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders.orderedItems}" var="orderItem">
					<tr>
						<td>${orderItem.product.productName}</td>
						<td>${orderItem.product.productPrice}</td>
						<td>${orderItem.orderedItemsQuantity}</td>
						<td>${orderItem.orderedItemsTotalPrice}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>Total Price</td>
					<td>${orders.ordersTotalPrice}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<center>
		<h2 style="color: aqua;">Thank You Visit Again.</h2>
	</center>
	<a href="${pageContext.request.contextPath}/">
		<center>
			<button type="button" class="btn btn-primary">Continue
				Shopping</button>
		</center>
	</a>
</body>
</html>