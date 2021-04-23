<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<%@ page isELIgnored="false"%>
<title>Login to UAC</title>

<!-- Stylesheet Path Mapping -->
<link 	type="text/css" 
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

<!-- Mozilla font for better readability -->
<link href='https://fonts.googleapis.com/css?family=Fira Sans'
	rel='stylesheet'>
	
<style type="text/css">
	body {
		font-family: 'Fira Sans';
	}
</style>

</head>
<body>
	<br>
	<h2>Login to University Admission Counseling Webapp</h2>
	<br>
	<div class="formDiv">
	${loginPageMessage}
	<form action="login" method="POST">
		<table>
			<tr>
				<td><input type="text" name="username" placeholder="Username"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" placeholder="Password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" class="button"></td>
			</tr>
		</table>
	</form>
	</div>
	<hr>
	<div class="centerText">
	<table class="centerTable">
		<tr>
			<td>
				<a href="${pageContext.request.contextPath}/"
				class="goHomeButton">Go Home</a>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>