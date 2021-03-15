package com.credibanco.assessment.library.exceptions;

public class EditorialNotExistException extends Exception {

	public static final String GENERAL_ERROR_CODE = "ELS-001";
	public static final String GENERAL_ERROR_MESSAGE = "La editorial no está registrada.";

	private static final long serialVersionUID = 1L;

	private final String errorCode;

	public EditorialNotExistException() {
		super(GENERAL_ERROR_MESSAGE);
		this.errorCode = GENERAL_ERROR_CODE;
	}

	public EditorialNotExistException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public EditorialNotExistException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public EditorialNotExistException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
