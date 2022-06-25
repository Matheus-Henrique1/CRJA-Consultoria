package com.crjaconsultoria.crjaconsultoriateste.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crjaconsultoria.crjaconsultoriateste.service.exceptions.DataIntegrityException;
import com.crjaconsultoria.crjaconsultoriateste.service.exceptions.ObjectNotFoundException;


@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandarError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
		
		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(),e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
}
