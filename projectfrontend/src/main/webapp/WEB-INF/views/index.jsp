
<%@include file="header.jsp"%>
<c:set var="image" value="${pageContext.request.contextPath}/resources/" />
<br>
<br>
<br>
<br>
<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">

			<div class="item active">
				<img src="${image}/homescreen.jpg" alt="bookstore1"
					style="width: 100%; height: 500px; margin: 0 auto;">
				<div class="carousel-caption">
					<!--<h3 style="color: White;">Book Store</h3>
				 <p style="color: black;">A world of books for young and old.</p> -->
				</div>
			</div>

			<div class="item">
				<img src="${image}/home1.jpg" alt="bookstore2"
					style="width: 100%; height: 500px; margin: 0 auto;">
				<div class="carousel-caption"></div>
			</div>

			<div class="item">
				<img src="${image}/b3.jpg" alt="bookstore3"
					style="width: 100%; height: 500px; margin: 0 auto;">
				<div class="carousel-caption">
					<!-- <h3>Novels</h3> -->
				</div>
			</div>

		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>
<br>

<div class="container">
	<c:forEach items="${categoryLists}" var="cat" begin="0" end="2">
		<h3>${cat.categoryName}</h3>
		<div class="row">
			<c:forEach items="${cat.products}" var="pro" begin="0" end="10">
				<div class="col-md-4">
					<div class="img-responsive">
						<a
							href="${pageContext.request.contextPath}/productInformation/${pro.productId}">
							<img src="${image}/${pro.productName}.jpg" alt="image"
							width="150px" height="150px" />
						</a>
						<div class="caption">
							<p>${pro.productName}</p>
							<p>${pro.productPrice}</p>
							<a
								href="${pageContext.request.contextPath}/customer/addToCart/${pro.productId}"><button
									class="btn btn-primary">Add cart</button></a>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
	</c:forEach>
</div>
</body>
</html>
