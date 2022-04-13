<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Appointments Page</title>
</head>
<body>
	<h4>${pageTitle}</h4>
	<hr />
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
				<td><a href="/vaccineappointments/loadeditscheduleappointment/${appointment.appointmentId}">Edit Scheduled Appointment</a> </td>
			</tr>
		</core:forEach>
		|
		<a href="/deleteschedulesppointment">Delete Scheduled Appointment</a>
	</table>
</body>
</html>