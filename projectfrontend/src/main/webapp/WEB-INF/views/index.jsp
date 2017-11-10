
<%@include file="header.jsp" %>
<c:set var="image" value="${pageContext.request.contextPath}/resources/" />
	<br><br><br><br>
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
					<img src="${image}/books.jpg" alt="bookstore1"
						style="width: 100%; height: 500px; margin: 0 auto;">
					<div class="carousel-caption">
						<h3 >Book Store</h3>
						<p>A world of books for young and old.</p>
					</div>
				</div>

				<div class="item">
					<img src="${image}/b2.jpg" alt="bookstore2"
						style="width: 100%; height: 500px; margin: 0 auto;">
					<div class="carousel-caption">
						<h3>Experience IT.</h3>
					</div>
				</div>

				<div class="item">
					<img src="${image}/b3.jpg" alt="bookstore3"
						style="width: 100%; height: 500px; margin: 0 auto;">
					<div class="carousel-caption">
						<h3>Novels</h3>
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

</body>
</html>
