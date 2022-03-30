package com.epam.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentDTO {
	
	
	private Integer appointmentId;
	
	@NotBlank(message = "Please enter vaccine dose number")
	@Size(max = 12)
	private String vaccineDoseNumber;
	
	@NotNull(message="Please enter vaccination date")
	//@Pattern(regexp = "([0-9]{2})/([0-9]{2})/([0-9]{4})",message = "Please enter date in dd/MM/YYYY format")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future
	private LocalDate date;
	
	@NotBlank(message="Please enter location details")
	private String location;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getVaccineDoseNumber() {
		return vaccineDoseNumber;
	}

	public void setVaccineDoseNumber(String vaccineDoseNumber) {
		this.vaccineDoseNumber = vaccineDoseNumber;
	}

	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId + ", vaccineDoseNumber=" + vaccineDoseNumber + ", date="
				+ date + ", location=" + location + "]";
	}
	
}
