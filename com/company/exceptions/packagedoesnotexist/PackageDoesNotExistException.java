package com.company.exceptions.packagedoesnotexist;

public class PackageDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4445758817226232348L;
	private static final String MESSAGE = "Package does not exist.";

	public PackageDoesNotExistException() {
		super(MESSAGE);
	}

	public PackageDoesNotExistException(String message) {
		super(message);
	}
}
