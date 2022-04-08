<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h3>Schedule Appointment Page</h3>
	<hr/>
	<hr />
	<hr />
	<hr/>
	<hr />
	<hr />
	<form:form action="/appointments/scheduleappointment" method="post"  modelAttribute="appointmentDTO"  >
		<table border="1">
			
			<tr>
				<td>Vaccine Dose Number</td>
				<td><form:input path="vaccineDoseNumber" /></td> 
				<td><form:errors path="vaccineDoseNumber" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Schedule Date</td>
				<td><form:input path="date" /></td>
				<td><form:errors path="date" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><form:input path="location" /></td>
				<td><form:errors path="location" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Schedule Appoinment"></td>
			</tr>
		</table>
	</form:form>
	<span style="color: red">${errormsg}</span>
</body>
</html>