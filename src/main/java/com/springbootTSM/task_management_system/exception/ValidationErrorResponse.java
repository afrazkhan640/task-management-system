package com.springbootTSM.task_management_system.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse {

	private String message;
	private Map<String , String> error;
	private int status;
	private LocalDateTime timeStamp;
	
	public ValidationErrorResponse(String message, Map<String, String> error, int status) {
		this.message = message;
		this.error = error;
		this.status = status;
		this.timeStamp=LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public Map<String, String> getError() {
		return error;
	}

	public int getStatus() {
		return status;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	
	
	
}
