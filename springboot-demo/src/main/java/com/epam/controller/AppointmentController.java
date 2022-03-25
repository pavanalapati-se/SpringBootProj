package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AppointmentDTO;
import com.epam.service.AppointmentService;

@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/appointments")
	public ModelAndView getAppointments() {
		
		List<AppointmentDTO> appointments =  appointmentService.getAppointments();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Appointments Page");
		modelAndView.addObject("appointments", appointments);
		modelAndView.setViewName("viewAppointments");
		
		return modelAndView;
	}
	
	@GetMapping("/loadscheduleappointment")
	public ModelAndView loadScheduleAppointment() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduleAppointment");
		return modelAndView;
	}
	
	@PostMapping("/scheduleappointment")
	public ModelAndView schduleAppointment(AppointmentDTO appointmentDTO) {
		
		ModelAndView modelAndView = new ModelAndView();
			appointmentService.createAppointment(appointmentDTO);
			modelAndView.addObject("successmsg", "Vaccine schdueled successfully");
			modelAndView.setViewName("success");
		return modelAndView;
	}

}
