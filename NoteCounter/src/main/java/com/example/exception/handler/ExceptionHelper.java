package com.example.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.InvalidInputException;

@ControllerAdvice
public class ExceptionHelper {
	
	@ExceptionHandler(value = {InvalidInputException.class})
	public ResponseEntity<Object> handleException(InvalidInputException e){
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleException(Exception e){
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
