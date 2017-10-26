<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Ecommerce</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">


body{
	
    background-image: url("${pageContext.request.contextPath}/resources/ecommerce_image1.png");
    /* Full height */
    height: 100%; 

    /*Center and scale the image nicely*/ 
    background-position:center & fixed;
    background-repeat: no-repeat;
    background-size: cover;
    
    
}
  .navbar-brand {
  padding: 0px;
}
.navbar-brand>img {
  height: 100%;
  padding: 2px;
  width: auto;
}

.navbar-custom1 .nav > li > a:focus,
.navbar-custom1 .nav > li > a:hover,
.navbar-custom1 .nav > li.active >a {
  background-color: LightBlue;
}
 </style>
</head>
<body >

<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom1">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="https://www.amazon.in/"><img src="${pageContext.request.contextPath}/resources/ecommerce_image.png">
      </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="AboutUs.jsp">About us.</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="SignIn.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
 

</body>
</html>
