package com.epam.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.dto.AppointmentDTO;

@Repository
public class AppointmentDao {

	List<AppointmentDTO> appointments = new ArrayList<>();
	
	
	public void schduledAppointment(AppointmentDTO appointmentDTO) {
		appointments.add(appointmentDTO);
	}
	
	public List<AppointmentDTO> listAppointments(){
		
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setAppointmentId(100);
		appointmentDTO.setVaccineDoseNumber("Vaccine 1st Dose");
		appointmentDTO.setDate("26/03/2022");
		appointmentDTO.setLocation("Hyderabad");
		
		AppointmentDTO appointmentDTO1 = new AppointmentDTO();
		appointmentDTO1.setAppointmentId(101);
		appointmentDTO1.setVaccineDoseNumber("Vaccine 2nd Dose");
		appointmentDTO1.setDate("03/04/2022");
		appointmentDTO1.setLocation("Hyderabad");
		
		appointments.add(appointmentDTO);
		appointments.add(appointmentDTO1);
		
		return appointments;
	}
}
