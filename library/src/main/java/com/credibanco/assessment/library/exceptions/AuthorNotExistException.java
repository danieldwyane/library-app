package com.credibanco.assessment.library.exceptions;

public class AuthorNotExistException extends Exception {

	public static final String GENERAL_ERROR_CODE = "ALS-001";
	public static final String GENERAL_ERROR_MESSAGE = "El autor no está registrado.";

	private static final long serialVersionUID = 1L;

	private final String errorCode;

	public AuthorNotExistException() {
		super(GENERAL_ERROR_MESSAGE);
		this.errorCode = GENERAL_ERROR_CODE;
	}

	public AuthorNotExistException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public AuthorNotExistException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public AuthorNotExistException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
