package com.springbootTSM.task_management_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<ApiError> handleTaskNotFound(TaskNotFoundException e){
		
		ApiError error=new ApiError(e.getMessage(),HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleValidation(MethodArgumentNotValidException e){
		
		Map<String , String> map=new HashMap<>();
		List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
		
		for(FieldError error: fieldErrors) {
			String fieldName=error.getField();
			String message=error.getDefaultMessage();
			
			map.put(fieldName, message);
		}
		
		ValidationErrorResponse response=
				new ValidationErrorResponse(
			 	  "Validation Failed", 
				  map,HttpStatus.BAD_REQUEST.value()
				  );
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(InvalidTaskStateException.class)
	public ResponseEntity<ApiError> apiStatus(InvalidTaskStateException e){
		ApiError error=new ApiError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}