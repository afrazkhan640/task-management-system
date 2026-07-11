package com.springbootTSM.task_management_system.dto.request;

import com.springbootTSM.task_management_system.enums.TaskPriority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequestDto {

	
	@NotBlank(message="Title should not be blank")
	@NotNull(message="title cannot be null")
	@Size(min=3, max=100 , message="Title must be b/w 3 and 100 characters")
	private String title;
	
	@NotBlank(message="Description Should not be blank")
	@NotNull(message="Description cannot be null")
	@Size(min=3, max=100 , message="Description size must be b/w 3 and 100 characters")
	private String description;
	
	@NotNull(message="Priority cannot be Null")
	private TaskPriority priority;
}
