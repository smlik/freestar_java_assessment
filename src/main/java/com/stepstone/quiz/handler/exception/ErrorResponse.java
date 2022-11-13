package com.stepstone.quiz.handler.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorResponse {
	String code;
	String message;
	LocalDateTime timestamp;
	
	public ErrorResponse( String code, String message ) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
}
