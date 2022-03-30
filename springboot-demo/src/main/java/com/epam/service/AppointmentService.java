package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.AppointmentRepository;
import com.epam.dto.AppointmentDTO;
import com.epam.entity.Appointment;
import com.epam.exception.AppointmentNotFoundException;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;

	private ModelMapper mapper;

	public List<AppointmentDTO> getAppointments() {

		Iterable<Appointment> appoinments = appointmentRepo.findAll();

		List<Appointment> appointmentList = new ArrayList<>();
		appoinments.forEach(appointmentList::add);
		return toDTOList(appointmentList);
	}

	public void createAppointment(AppointmentDTO appointmentDTO) {
		appointmentRepo.save(toEntity(appointmentDTO));
	}

	public void editSchduledAppointment(AppointmentDTO appointmentDTO) {

	}

	public AppointmentDTO getAppointmentDetailsById(int appointmentId) {
		Optional<Appointment> optionalAppointment = appointmentRepo.findById(appointmentId);
		Appointment appointment = optionalAppointment
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id:" + appointmentId));
		return toDTO(appointment);
	}
	
	public List<AppointmentDTO> searchBasedOnLocation(String location){
		return toDTOList(appointmentRepo.findByLocation(location));
	}

	public List<AppointmentDTO> toDTOList(List<Appointment> appointments) {

		mapper = new ModelMapper();

		return appointments.stream().map(appointmentEntity -> mapper.map(appointmentEntity, AppointmentDTO.class))
				.collect(Collectors.toList());

	}

	public Appointment toEntity(AppointmentDTO appointmentDTO) {

		mapper = new ModelMapper();

		return mapper.map(appointmentDTO, Appointment.class);

	}

	public AppointmentDTO toDTO(Appointment appointment) {

		mapper = new ModelMapper();

		return mapper.map(appointment, AppointmentDTO.class);

	}
}
