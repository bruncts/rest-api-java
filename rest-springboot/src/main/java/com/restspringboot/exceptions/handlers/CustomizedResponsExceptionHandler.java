package com.restspringboot.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restspringboot.exceptions.StandardExceptionResponse;
import com.restspringboot.exceptions.UnsupportedMathException;

@ControllerAdvice
@RestController
public class CustomizedResponsExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StandardExceptionResponse> handleAllException(Exception ex,  WebRequest request){
		StandardExceptionResponse standardExceptionResponse = new StandardExceptionResponse(Instant.now(), ex.getLocalizedMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(standardExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UnsupportedMathException.class)
	public final ResponseEntity<StandardExceptionResponse> handleBadRequestException(Exception ex,  WebRequest request){
		StandardExceptionResponse standardExceptionResponse = new StandardExceptionResponse(Instant.now(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(standardExceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
}
