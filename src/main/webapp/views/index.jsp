<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>University Admission Counseling Webapp Home</title>


<!-- Stylesheet Path Mapping -->
<link 	type="text/css" 
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

<!-- Mozilla font for better readability -->
<link 	href='https://fonts.googleapis.com/css?family=Fira Sans'
		rel='stylesheet'>

<style type="text/css">
body {
	font-family: 'Fira Sans';
}
</style>


</head>
<body>
	<br>
	<h1>University Admission Counseling Webapp by Aniket Singh</h1>
	<br>
	<table class="centerTable">
		<tr>
			<td><a href="login-form" class="bigButton">Login</a></td>
			<td><a href="registration" class="bigButton">Register</a></td>
		</tr>
	</table>

</body>
</html>
