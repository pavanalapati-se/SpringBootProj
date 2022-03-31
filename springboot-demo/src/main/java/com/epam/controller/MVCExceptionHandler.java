package com.epam.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.epam.exception.AppointmentNotFoundException;

@ControllerAdvice
public class MVCExceptionHandler {

	@ExceptionHandler(value = AppointmentNotFoundException.class)
	public HandlerExceptionResolver handleAppointmentNotFoundException(Exception exception) {
		
		
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
		
		simpleMappingExceptionResolver.addStatusCode("error", 401);
		
		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", exception.getMessage());
//		mv.setViewName("error");
		return simpleMappingExceptionResolver;
	}
}
