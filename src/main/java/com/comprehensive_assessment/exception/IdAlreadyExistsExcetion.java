package com.comprehensive_assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class IdAlreadyExistsExcetion extends RuntimeException{
	
	private String message;

	public IdAlreadyExistsExcetion(String messages) {
		super(messages);
		this.message=messages;
		getMessage();
		
	}

	public IdAlreadyExistsExcetion() {
		super("Employee already exists in the database");
	}

	
}
