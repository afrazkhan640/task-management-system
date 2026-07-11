package com.springbootTSM.task_management_system.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.springbootTSM.task_management_system.dto.request.TaskRequestDto;
import com.springbootTSM.task_management_system.dto.request.UserRequestDto;
import com.springbootTSM.task_management_system.dto.response.TaskResponseDto;
import com.springbootTSM.task_management_system.dto.response.UserResponseDto;
import com.springbootTSM.task_management_system.entity.Task;
import com.springbootTSM.task_management_system.entity.User;
public class Mapper {

	public static Task dtoToTaskEntity(TaskRequestDto dto) {
		
		Task t1=new Task();
		t1.setTitle(dto.getTitle());
		t1.setDescription(dto.getDescription());
		t1.setPriority(dto.getPriority());
		
		return t1;
	}
	
	public static TaskResponseDto taskToResponseDto(Task task) {
		
		TaskResponseDto dto=new TaskResponseDto();
		dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority());
        dto.setStatus(task.getStatus());

        return dto;
	}
	
	public static List<TaskResponseDto> taskToResponseDtos(List<Task> task){
		return task.stream().
				map(t->Mapper.taskToResponseDto(t)).
				collect(Collectors.toList());
     }
	
	public static User userRequestDtoToUSerEntity(UserRequestDto dto) {
		
		User user=new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setRole(dto.getRole());
		
		return user;
	
	}
	
	public static UserResponseDto userEntityToUserResponseDto(User user) {
		
		UserResponseDto response=new UserResponseDto();
		response.setUserId(user.getUserId());
		response.setUsername(user.getUsername());
		response.setRole(user.getRole());
		
		return response;
	}
	
	
}
