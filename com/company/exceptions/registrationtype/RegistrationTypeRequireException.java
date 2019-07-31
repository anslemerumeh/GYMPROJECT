package com.company.exceptions.registrationtype;

public class RegistrationTypeRequireException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4385034149545362349L;
	private static final String MESSAGE = "Registration type is a required field";

	public RegistrationTypeRequireException() {
		super(MESSAGE);
	}

	public RegistrationTypeRequireException(String message) {
		super(message);
	}
}
