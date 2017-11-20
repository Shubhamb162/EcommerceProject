<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="header.jsp"%>
<br>
<br>
<br>
<div class="container">
	<c:if test="${fn:length(cartItems)!=0}">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
					<th>Amount</th>
					<th>Update/Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartItems}" var="cartItem">
					<tr>
						<td>${cartItem.product.productName}</td>
						<td>${cartItem.product.productPrice}</td>

						<form
							action="${pageContext.request.contextPath}/customer/cartItemsEdit/${cartItem.cartItemsId}"
							method="post">
							<td><input type="number" name="quantity"
								value="${cartItem.cartItemsQuantity}" /></td>
							<td>${cartItem.cartItemsPrice}</td>
							<td><input type="submit" class="btn btn-info" value="Edit">
								<a
								href="${pageContext.request.contextPath}/customer/cartItemsDelete/${cartItem.cartItemsId}">
									<button type="button" class="btn btn-danger">Delete</button>
							</a></td>
						</form>


					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>Total Price</td>
					<td>${cart.cartTotalPrice}</td>
					<td><a
						href="${pageContext.request.contextPath}/customer/checkout/${cart.cartId}">

							<button type="button" class="btn btn-primary">Checkout</button>



					</a></td>
				</tr>

			</tbody>

		</table>
	</c:if>
	<c:if test="${fn:length(cartItems)==0}">
		<h1 style="text-align: center;">Your Cart Is Empty</h1>
		<a href="${pageContext.request.contextPath}/">
			<center>
				<button type="button" class="btn btn-primary">Continue
					Shopping</button>
			</center>
		</a>
	</c:if>

</div>
</body>
</html>