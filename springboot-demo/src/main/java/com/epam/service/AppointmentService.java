package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.AppointmentDao;
import com.epam.dto.AppointmentDTO;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	public List<AppointmentDTO> getAppointments() {
		return appointmentDao.listAppointments();
	}

	public void createAppointment(AppointmentDTO appointmentDTO) {
		appointmentDao.schduledAppointment(appointmentDTO);
	}

	public void editSchduledAppointment(AppointmentDTO appointmentDTO) {
		appointmentDao.editSchduledAppointment(appointmentDTO);
	}

	public AppointmentDTO getAppointmentDetailsById(int appointmentId) {
		return appointmentDao.getAppointmentById(appointmentId);
	}
}
