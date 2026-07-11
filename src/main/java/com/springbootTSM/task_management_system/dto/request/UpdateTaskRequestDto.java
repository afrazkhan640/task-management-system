package com.springbootTSM.task_management_system.dto.request;

import com.springbootTSM.task_management_system.enums.TaskPriority;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateTaskRequestDto {

	@Size(min=5 ,max=30)
	private String title;
	
	@Size(min=5, max=150)
	private String description;
	
	
	private TaskPriority taskpriority;
	
	
}
