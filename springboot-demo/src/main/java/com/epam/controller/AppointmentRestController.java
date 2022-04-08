package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.AppointmentDTO;
import com.epam.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/appointments")
public class AppointmentRestController {
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	@Operation(description = "It fetchs all the appointments")
	@ApiResponses({ @ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "200", description = "successfull") })
	public ResponseEntity<List<AppointmentDTO>> getAppointments() {

		return new ResponseEntity<>(appointmentService.getAppointments(), HttpStatus.OK);

	}

	@GetMapping("/{appointmentid}")
	public AppointmentDTO getAppointmentByAppointmentId(@PathVariable int id) {

		return appointmentService.getAppointmentDetailsById(id);

	}
}
