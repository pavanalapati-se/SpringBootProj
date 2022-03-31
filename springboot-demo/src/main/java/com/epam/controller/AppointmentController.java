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

		ModelAndView mv = new ModelAndView();
		mv.addObject("pageTitle", "Appointments Page");
		mv.addObject("appointments", appointments);
		mv.setViewName("viewAppointments");

		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView getAppointmentByAppointmentId(@PathVariable int id) {
		AppointmentDTO appointmentDTO = appointmentService.getAppointmentDetailsById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("appointmentDTO", appointmentDTO);
		mv.setViewName("viewAppointment");
		return mv;
	}

	@GetMapping("/loadscheduleappointment")
	public ModelAndView loadScheduleAppointment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("appointmentDTO", new AppointmentDTO());
		mv.setViewName("scheduleAppointment");
		return mv;
	}

	@PostMapping("/scheduleappointment")
	public ModelAndView schduleAppointment(@Valid @ModelAttribute AppointmentDTO appointmentDTO, BindingResult result) {

		ModelAndView mv = new ModelAndView();
		if (!result.hasErrors()) {
			appointmentService.createAppointment(appointmentDTO);
			mv.addObject("successmsg", "Vaccine schdueled successfully.");
			mv.setViewName("success");
		} else {
			mv.setViewName("scheduleAppointment");
		}

		return mv;
	}

	@GetMapping("/loadeditscheduleappointment/{appointmentid}")
	public ModelAndView loadEditPageForScheduleAppointment(
			@PathVariable(name = "appointmentid") Integer appointmentid) {

		ModelAndView mv = new ModelAndView();

		Optional<AppointmentDTO> appointmentDTO = appointmentService.getAppointments().stream()
				.filter(ad -> ad.getAppointmentId().equals(appointmentid)).findAny();

		mv.addObject("appointmentDTO", appointmentDTO.get());

		mv.setViewName("scheduleAppointment");
		return mv;
	}

	@PostMapping("/editscheduleappointment")
	public ModelAndView editschduleAppointment(@Valid @ModelAttribute AppointmentDTO appointmentDTO,
			BindingResult result) {

		ModelAndView mv = new ModelAndView();
		if (!result.hasErrors()) {
			appointmentService.createAppointment(appointmentDTO);
			mv.addObject("successmsg", "Vaccine schdueled successfully.");
			mv.setViewName("success");
		} else {
			mv.setViewName("scheduleAppointment");
		}

		return mv;
	}

	@GetMapping("/loadseaerchpage")
	public ModelAndView loadSearchPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchByLocation");
		return mv;
	}

	@PostMapping("/searchpage")
	public ModelAndView searchByLocation(@RequestParam("location") String location) {

		List<AppointmentDTO> appointments = appointmentService.searchBasedOnLocation(location);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("appointments", appointments);

		mv.setViewName("searchByLocation");
		return mv;
	}

}
