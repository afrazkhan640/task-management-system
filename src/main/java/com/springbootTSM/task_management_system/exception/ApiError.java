package com.springbootTSM.task_management_system.exception;

import java.time.LocalDateTime;

public class ApiError {

	private String message;
	private int status;
	private LocalDateTime timeSatamp;
	
	public ApiError(String message, int status) {
		this.message = message;
		this.status = status;
		this.timeSatamp = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public LocalDateTime getTimeSatamp() {
		return timeSatamp;
	}

}
