package com.restspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsupportedMathException(String ex) {
		super(ex);
	}

}