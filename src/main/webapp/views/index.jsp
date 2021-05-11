<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<html>
<head>
	
	<title>University Admission Counseling Webapp Home</title>
	
	<!-- Stylesheet Path Mapping -->
	<!--
	<link type = "text/css"
	      rel = "stylesheet"
	      href = "${pageContext.request.contextPath}/resources/css/style.css"/>
	-->
	
	<!-- BOOTSTRAP REQUIREMENTS -->
	<meta charset = "utf-8">
	<meta name = "viewport" content = "width=device-width, initial-scale=1">
	<link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src = "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<!-- FIRA SANS CONDENSED FONT -->
	<link href = "https://fonts.googleapis.com/css?family=Fira Sans Condensed" rel = "stylesheet">
	<style>
		body
		{
			font-family : 'Fira Sans Condensed';
		}
		
		a:hover
		{
			box-shadow : 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
		}
	</style>

</head>
<body>
<div class = "container">
	<br>
	<h1 class = "text-center">University Admission Counseling Webapp by Aniket Singh</h1>
	<hr>
	<br>
	<div class = "row">
		<div class = "col-sm-4"></div>
		<div class = "col-sm-2">
			<a href = "login-form" class = "btn btn-primary btn-block">Login</a>
		</div>
		<div class = "col-sm-2">
			<a href = "registration" class = "btn btn-primary btn-block">Register</a>
		</div>
		<div class = "col-sm-4"></div>
	</div>
	<br>
	<hr>
</div>
</body>
</html>
