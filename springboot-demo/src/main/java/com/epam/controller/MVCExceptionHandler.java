package com.epam.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.epam.exception.AppointmentNotFoundException;

@ControllerAdvice
public class MVCExceptionHandler {

	@ExceptionHandler(value = AppointmentNotFoundException.class)
	public ModelAndView handleAppointmentNotFoundException(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
