<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMISSION RESULTS</title>

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
	${admissionResult}
	<hr>
	<div class="centerText">
	<table class="centerTable">
		<tr>
			<td>
				<a href="logout" 
				class="logoutButton">Logout</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/"
				class="goHomeButton">Go Home</a>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>