package com.springbootTSM.task_management_system.dto.response;

import com.springbootTSM.task_management_system.enums.TaskPriority;
import com.springbootTSM.task_management_system.enums.TaskStatus;

import lombok.Data;

@Data

public class TaskResponseDto {
	    private Integer id;
	    private String title;
	    private String description;
	    private TaskPriority priority;
	    private TaskStatus status;
		
}
