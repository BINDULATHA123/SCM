package com.example.demo.controller;


import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodb.MongoException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberFormatException(NumberFormatException numberformatexception) {
		return ResponseEntity.badRequest().body("Invalid input format");
	}

	@ExceptionHandler(MongoException.class)
	public ResponseEntity<String> handleSQLException(MongoException mongoexception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database error");
	}

	@ExceptionHandler({ NullPointerException.class, ArrayIndexOutOfBoundsException.class })
	public ResponseEntity<String> handleRuntimeException(RuntimeException runtimeexception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Runtime error");
	}

	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<String> handleClassNotFoundException(ClassNotFoundException classnotfoundexception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Class not found error");
	}

	@ExceptionHandler(ConverterNotFoundException.class)
	public ResponseEntity<String> handleConverterNotFoundException(ConverterNotFoundException converternotfoundexception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Converter not found error");
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException1(RuntimeException runtimeexception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Runtime error");
	}

}
