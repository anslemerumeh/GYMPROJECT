package com.company.exceptions.idnumberDoesNotExist;

public class IdNumberDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878666472546900113L;
	/**
	 * 
	 */

	private static final String MESSAGE = "Id number does not exist";

	public IdNumberDoesNotExistException() {

		super(MESSAGE);
	}

	public IdNumberDoesNotExistException(String message) {
		super(message);
	}

}
