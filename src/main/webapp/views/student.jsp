<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>UAC Student Portal</title>

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
	<h2>Welcome to UAC Students Portal</h2>
	
	<table class="infoTable">
		<tr class="infoTR">
			<th class="infoTH">Institute</th>
			<core:forEach items="${courses}" var="course">
				<th class="infoTH">${course}</th>
			</core:forEach>
		</tr>
		<core:forEach var="institute" items="${instituteNames}">
		<tr class="infoTR">
			<td class="infoTD">${institute}</td>
			<core:forEach var="course" items="${courses}">
			<td class="infoTD">
				<core:url var="addLink" value="/addPListItem">
					<core:param name="ins" value="${institute}"/>
					<core:param name="crs" value="${course}"/>
				</core:url>
				<a href="${addLink}" style="text-decoration: none;">Add</a>
			</td>
			</core:forEach>
		</tr>
		</core:forEach>
	</table>
	
	<br>
	<br>
	<div class="rankNotif">Since no real exam was held you have been randomly assigned exam rank of <b>${rank}</b> for demonstration purposes</div>
	
	<h3>Your Preference List for Admission</h3>
	${studentPageMessage}
	<br>
	<table class="infoTableStudent">
		<tr class="infoTR">
			<th class="infoTH">Course</th>
			<th class="infoTH">Institute</th>
			<th class="infoTH">Move Up</th>
			<th class="infoTH">Move Down</th>
			<th class="infoTH">Delete</th>
		</tr>
		<core:forEach items="${pList}" var="pItem">
		<tr class="infoTR">
			<td class="infoTD">${pItem.course}</td>
			<td class="infoTD">${pItem.institute}</td>
			<td class="infoTD">
				<core:url var="moveUpItem" value="/movePListItem">
					<core:param name="pCrs" value="${pItem.course}" />
					<core:param name="pIns" value="${pItem.institute}" />
					<core:param name="move" value="UP" />
				</core:url> 
				<a href="${moveUpItem}">Up</a>
			</td>
			<td class="infoTD">
				<core:url var="moveDownItem" value="/movePListItem">
					<core:param name="pCrs" value="${pItem.course}" />
					<core:param name="pIns" value="${pItem.institute}" />
					<core:param name="move" value="DOWN" />
				</core:url> 
				<a href="${moveDownItem}">Down</a>
			</td>
			<td class="infoTD">
				<core:url var="delItem" value="/delPListItem">
					<core:param name="pCrs" value="${pItem.course}" />
					<core:param name="pIns" value="${pItem.institute}" />
				</core:url> 
				<a href="${delItem}" onclick="if (!(confirm('Are you sure you want to delete this item from list?'))) return false">Delete</a>
			</td>
		</tr>	
		</core:forEach>
	</table>
	
	<br>
	<div class="centerText">
		<core:url var="submitLink" value="/getAdmission"></core:url>
		<a href="${submitLink}" class="bigButton" onclick="if (!(confirm('Are you sure you want to send this preference list for admission?'))) return false">SUBMIT for Admission!</a>
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