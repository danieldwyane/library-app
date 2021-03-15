package com.credibanco.assessment.library.exceptions;

public class BookException extends Exception {

	public static final String GENERAL_ERROR_CODE = "BLS-001";
	public static final String GENERAL_ERROR_MESSAGE = "No es posible registrar el libro, se alcanzó el máximo permitido.";

	private static final long serialVersionUID = 1L;

	private final String errorCode;

	public BookException() {
		super(GENERAL_ERROR_MESSAGE);
		this.errorCode = GENERAL_ERROR_CODE;
	}

	public BookException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public BookException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BookException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
