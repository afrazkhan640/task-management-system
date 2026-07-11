package com.springbootTSM.task_management_system.exception;

public class InvalidTaskStateException extends RuntimeException {

	public InvalidTaskStateException(String message){
		super(message);
	}
}
