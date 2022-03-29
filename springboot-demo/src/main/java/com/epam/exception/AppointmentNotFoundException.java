package com.epam.exception;

public class AppointmentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4192640404375414304L;

	public AppointmentNotFoundException(String message) {
		super(message);
	}
}
