<head>
<title>Checkout</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<br>
	<br>
	<br>
	<div class="container">
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
				<c:forEach items="${cartItems}" var="cartItem">
					<tr>
						<td>${cartItem.product.productName}</td>
						<td>${cartItem.product.productPrice}</td>
						<td>${cartItem.cartItemsQuantity}</td>
						<td>${cartItem.cartItemsPrice}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>Total Price</td>
					<td>${cart.cartTotalPrice}</td>
					<%-- <td><a
					href="${pageContext.request.contextPath}/customer/checkout/${cart.cartId}">
						<button type="button" class="btn btn-warning">Checkout</button>
				</a></td> --%>
				</tr>
			</tbody>
		</table>
		<center>
			<a href="${pageContext.request.contextPath}/customer/myCart">
				<button type="button" class="btn btn-danger"">Cancel</button>
			</a> <span> </span> <a
				href="${pageContext.request.contextPath}/customer/order">
				<button type="button" class="btn btn-success"">Confirm</button>
			</a>
		</center>
	</div>
</body>
</html>