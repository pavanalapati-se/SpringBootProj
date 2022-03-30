package com.epam.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AppointmentDTO;
import com.epam.service.AppointmentService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	public ModelAndView getAppointments() {

		List<AppointmentDTO> appointments = appointmentService.getAppointments();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Appointments Page");
		modelAndView.addObject("appointments", appointments);
		modelAndView.setViewName("viewAppointments");

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView getAppointmentByAppointmentId(@PathVariable int id) {
		AppointmentDTO appointmentDTO = appointmentService.getAppointmentDetailsById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("appointmentDTO", appointmentDTO);
		modelAndView.setViewName("viewAppointment");
		return modelAndView;
	}

	@GetMapping("/loadscheduleappointment")
	public ModelAndView loadScheduleAppointment() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("appointmentDTO", new AppointmentDTO());
		modelAndView.setViewName("scheduleAppointment");
		return modelAndView;
	}

	@PostMapping("/scheduleappointment")
	public ModelAndView schduleAppointment(@Valid @ModelAttribute AppointmentDTO appointmentDTO, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		if (!result.hasErrors()) {
			appointmentService.createAppointment(appointmentDTO);
			modelAndView.addObject("successmsg", "Vaccine schdueled successfully.");
			modelAndView.setViewName("success");
		} else {
			modelAndView.setViewName("scheduleAppointment");
		}

		return modelAndView;
	}

	@GetMapping("/loadeditscheduleappointment/{appointmentid}")
	public ModelAndView loadEditPageForScheduleAppointment(
			@PathVariable(name = "appointmentid") Integer appointmentid) {

		ModelAndView modelAndView = new ModelAndView();

		Optional<AppointmentDTO> appointmentDTO = appointmentService.getAppointments().stream()
				.filter(ad -> ad.getAppointmentId().equals(appointmentid)).findAny();

		modelAndView.addObject("appointmentDTO", appointmentDTO.get());

		modelAndView.setViewName("scheduleAppointment");
		return modelAndView;
	}

	@PostMapping("/editscheduleappointment")
	public ModelAndView editschduleAppointment(@Valid @ModelAttribute AppointmentDTO appointmentDTO,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		if (!result.hasErrors()) {
			appointmentService.createAppointment(appointmentDTO);
			modelAndView.addObject("successmsg", "Vaccine schdueled successfully.");
			modelAndView.setViewName("success");
		} else {
			modelAndView.setViewName("scheduleAppointment");
		}

		return modelAndView;
	}

	@GetMapping("/loadseaerchpage")
	public ModelAndView loadSearchPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchByLocation");
		return modelAndView;
	}

	@PostMapping("/searchpage")
	public ModelAndView searchByLocation(@RequestParam("location") String location) {

		List<AppointmentDTO> appointments = appointmentService.searchBasedOnLocation(location);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("appointments", appointments);

		modelAndView.setViewName("searchByLocation");
		return modelAndView;
	}

}
