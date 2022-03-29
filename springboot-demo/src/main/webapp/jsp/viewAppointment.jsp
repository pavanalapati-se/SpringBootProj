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
	<hr />
	<table border="1">
		<tr>
			<th>Appointment Id</th>
			<th>Vaccine Dose Number</th>
			<th>Schdueled Date</th>
			<th>Location</th>
		</tr>

		<tr>
			<td>${appointmentDTO.appointmentId}</td>
			<td>${appointmentDTO.vaccineDoseNumber}</td>
			<td>${appointmentDTO.date}</td>
			<td>${appointmentDTO.location}</td>
			<td><a
				href="/appointments/loadeditscheduleappointment/${appointment.appointmentId}">Edit
					Scheduled Appointment</a> | <a href="/deleteschedulesppointment">Delete
					Scheduled Appointment</a></td>
		</tr>


	</table>
</body>
</html>