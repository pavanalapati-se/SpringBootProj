package com.epam.dto;

public class AppointmentDTO {
	
	private int appointmentId;
	
	private String vaccineDoseNumber;
	
	private String date;
	
	private String location;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getVaccineDoseNumber() {
		return vaccineDoseNumber;
	}

	public void setVaccineDoseNumber(String vaccineDoseNumber) {
		this.vaccineDoseNumber = vaccineDoseNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
