package com.epam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epam.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment> findByLocation(String location);

	@Query(value = "Select a from Appointment a where a.date >=?1")
	public List<Appointment> getAppointmentsByDate(LocalDate vaccineDate);

	@Query(value = "Select a from Appointment a where a.vaccineDoseNumber = :vaccinedose and a.location = :loc")
	public List<Appointment> getAppointmentsDetailsByVaccineAndLocation(@Param("loc") String location,
			@Param("vaccinedose") String vaccineDoseNumber);
	
	@Modifying
	@Query(value = "delete from Appointment a where a.location =?1")
	public void deleteAppointment(String location);
	

}
