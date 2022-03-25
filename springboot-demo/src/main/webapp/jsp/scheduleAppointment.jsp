<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Schedule Appointment Page</h3>
	<hr />
	<form action="/appointments/scheduleappointment" method="post">
		<table border="1">
			<tr>
				<td>Appointment Id</td>
				<td><input type="text" name="appointmentId" /></td>
			</tr>
			<tr>
				<td>Vaccine Dose Number</td>
				<td><input type="text" name="vaccineDoseNumber" /></td>
			</tr>
			<tr>
				<td>Schedule Date</td>
				<td><input type="text" name="date" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="location" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Schedule Appoinment"></td>
			</tr>
		</table>
	</form>
	<span style="color:red">${errormsg}</span>
</body>
</html>