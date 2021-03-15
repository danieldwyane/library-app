package com.credibanco.assessment.library.exceptions;

public class BookExistException extends Exception {

	public static final String GENERAL_ERROR_CODE = "BLS-001";
	public static final String GENERAL_ERROR_MESSAGE = "No es posible registrar el libro, ya existe.";

	private static final long serialVersionUID = 1L;

	private final String errorCode;

	public BookExistException() {
		super(GENERAL_ERROR_MESSAGE);
		this.errorCode = GENERAL_ERROR_CODE;
	}

	public BookExistException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public BookExistException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BookExistException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
