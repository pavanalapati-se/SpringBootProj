<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/vaccineappointments/searchpage" method="post">
		Location : <input type="text" name="location"> <br /> <br />
		<input type="submit" value="Search Location">

		<table border="1">
			<tr>
				<th>Appointment Id</th>
				<th>Vaccine Dose Number</th>
				<th>Schdueled Date</th>
				<th>Location</th>
			</tr>
			<core:forEach items="${appointments}" var="appointment">
				<tr>
					<td>${appointment.appointmentId}</td>
					<td>${appointment.vaccineDoseNumber}</td>
					<td>${appointment.date}</td>
					<td>${appointment.location}</td>
				</tr>
			</core:forEach>

		</table>
	</form>
</body>
</html>