<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>

<title>UAC Administrators Area</title>

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
	<h2>Welcome to Administrators Area</h2>
	
	<table class="infoTable">
		<tr>
			<th class="infoTH">Institute</th>
			<core:forEach items="${courses}" var="course">
				<th class="infoTH">${course}</th>
			</core:forEach>
		</tr>
		<core:forEach var="institute" items="${institutes}">
			<tr class="infoTR">
				<td class="infoTD">${institute.name }</td>
				<td class="infoTD">${institute.cse }</td>
				<td class="infoTD">${institute.it }</td>
				<td class="infoTD">${institute.ece }</td>
				<td class="infoTD">${institute.me }</td>
				<td class="infoTD">${institute.ce }</td>
			</tr>
		</core:forEach>
	</table>
	<br>
	<br>
	<div class="adminFormDiv">
	<h3>Add/Subtract Seats</h3>
	<form action="seatOp" method="POST">
		<table class="centerTable">
			<tr>
				<td>
					<select name="SOP_institute">
						<core:forEach var="institute" items="${institutes}">
							<option>${institute.name }</option>
						</core:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<select name="SOP_branch">
						<core:forEach items="${courses}" var="course">
							<option>${course}</option>
						</core:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<select name="SOP_operation">
							<option>Add</option>
							<option>Subtract</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="number" name="SOP_magnitude" value="0" min="0"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Apply Changes" class="button"></td>
			</tr>
		</table>
	</form>
	</div>
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