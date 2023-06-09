package com.capgemini.go.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.AddressNotFoundException;

@RestControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<String> handleAddressNotFoundException() {
		return new ResponseEntity<>("Address not found!", HttpStatus.NOT_FOUND);
	}
}
