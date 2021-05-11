<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<html>
<head>
	<title>Register User at UAC</title>
	
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
	<h1 class = "text-center">Register for University Admission Counseling Webapp</h1>
	<hr>
	<br>
	<div class = "row">
		<div class = "col-sm-4"></div>
		<div class = "col-sm-4">
			<div class = "text-center">
				${registerPageMessage}
			</div>
			<form action = "processRegistration" method = "POST">
				<div class = "form-group">
					<input type = "text" name = "name" class = "form-control text-center" placeholder = "Your Name"/>
				</div>
				<div class = "form-group">
					<input type = "text" name = "username" class = "form-control text-center" placeholder = "Username"/>
				</div>
				<div class = "form-group">
					<input type = "password" name = "password" class = "form-control text-center" placeholder = "Password"/>
				</div>
				<div class = "form-group">
					<select class = "form-control text-center" name = "privilege">
						<option value = "Admin">Administrator</option>
						<option value = "Student">Student</option>
					</select>
				</div>
				<input type = "submit" class = "btn btn-success btn-block" value = "Register" class = "button"/>
			</form>
		</div>
		<div class = "col-sm-4"></div>
	</div>
	<hr>
	<div class = "row">
		<div class = "col-sm-4"></div>
		<div class = "col-sm-4">
			<a href = "${pageContext.request.contextPath}/"
			   class = "btn btn-outline-dark btn-block"
			   role = "button">
				Go Home
			</a>
		</div>
		<div class = "col-sm-4"></div>
	</div>
</div>
</body>
</html>