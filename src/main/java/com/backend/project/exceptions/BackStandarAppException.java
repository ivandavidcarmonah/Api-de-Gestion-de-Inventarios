package com.backend.project.exceptions;

import org.springframework.http.HttpStatus;

public class BackStandarAppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

	public BackStandarAppException() {
		super();
	}

	public BackStandarAppException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public BackStandarAppException(HttpStatus status, String message, String message_1) {
		super();
		this.status = status;
		this.message = message;
		this.message = message_1;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
