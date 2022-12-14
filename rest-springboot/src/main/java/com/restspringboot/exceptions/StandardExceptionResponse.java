package com.restspringboot.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instant timestamp;
	private String message;
	private String datails;

	public StandardExceptionResponse(Instant timestamp, String message, String datails) {
		this.timestamp = timestamp;
		this.message = message;
		this.datails = datails;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDatails() {
		return datails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
