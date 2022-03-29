package com.epam.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.dto.AppointmentDTO;
import com.epam.exception.AppointmentNotFoundException;

@Repository
public class AppointmentDao {

	List<AppointmentDTO> appointments = new ArrayList<>();

	public void schduledAppointment(AppointmentDTO appointmentDTO) {
		appointments.add(appointmentDTO);
	}

	public void editSchduledAppointment(AppointmentDTO appointmentDTO) {
		if (appointments.removeIf(ad -> ad.getAppointmentId().equals(appointmentDTO.getAppointmentId()))) {
			appointments.add(appointmentDTO);
		}
	}

	public List<AppointmentDTO> listAppointments() {

		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setAppointmentId(100);
		appointmentDTO.setVaccineDoseNumber("Vaccine 1st Dose");
		appointmentDTO.setDate(LocalDate.now());
		appointmentDTO.setLocation("Hyderabad");

		AppointmentDTO appointmentDTO1 = new AppointmentDTO();
		appointmentDTO1.setAppointmentId(101);
		appointmentDTO1.setVaccineDoseNumber("Vaccine 2nd Dose");
		appointmentDTO1.setDate(LocalDate.now());
		appointmentDTO1.setLocation("Hyderabad");

		appointments.add(appointmentDTO);
		appointments.add(appointmentDTO1);

		return appointments;
	}

	public AppointmentDTO getAppointmentById(int appointmentId) {

		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setAppointmentId(100);
		appointmentDTO.setVaccineDoseNumber("Vaccine 1st Dose");
		appointmentDTO.setDate(LocalDate.now());
		appointmentDTO.setLocation("Hyderabad");

		AppointmentDTO appointmentDTO1 = new AppointmentDTO();
		appointmentDTO1.setAppointmentId(101);
		appointmentDTO1.setVaccineDoseNumber("Vaccine 2nd Dose");
		appointmentDTO1.setDate(LocalDate.now());
		appointmentDTO1.setLocation("Hyderabad");

		appointments.add(appointmentDTO);
		appointments.add(appointmentDTO1);
		
		return appointments.stream().filter(ad -> ad.getAppointmentId().equals(appointmentId)).findAny()
				.orElseThrow(() -> new AppointmentNotFoundException(
						"Appointment Details are not available with id :" + appointmentId));
	}
}
