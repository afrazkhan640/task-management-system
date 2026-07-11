package com.springbootTSM.task_management_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootTSM.task_management_system.dto.request.TaskRequestDto;
import com.springbootTSM.task_management_system.dto.request.UpdateTaskRequestDto;
import com.springbootTSM.task_management_system.dto.response.TaskResponseDto;
import com.springbootTSM.task_management_system.entity.Task;
import com.springbootTSM.task_management_system.mapper.Mapper;
import com.springbootTSM.task_management_system.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private TaskService taskService;
	
	public AdminController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public ResponseEntity<TaskResponseDto> createTask(
			@Valid @RequestBody TaskRequestDto dto){
		
		Task createdTask=taskService.createTask(dto);
		
		TaskResponseDto response =
	            Mapper.taskToResponseDto(createdTask);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<TaskResponseDto> getTaskByIdController(@PathVariable Integer id){
		
		Task task=taskService.findById(id);
		TaskResponseDto response= Mapper.taskToResponseDto(task);
		
		return ResponseEntity.ok(response);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<TaskResponseDto>> getAllTaskController(){
		
		List<Task> tasks=taskService.findAllTask();
		
		List<TaskResponseDto> dto= Mapper.taskToResponseDtos(tasks);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TaskResponseDto> updateTask(
			@PathVariable Integer id,@Valid @RequestBody UpdateTaskRequestDto dto){
		
		Task updatedTask=taskService.updateTask(id, dto);
		
		TaskResponseDto response=Mapper.taskToResponseDto(updatedTask);
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable int id) {
		
		taskService.deleteTask(id);
		
		return ResponseEntity.ok("Task deleted successfully");
	}
	
	
	@PatchMapping("/start/{id}")
	public ResponseEntity<TaskResponseDto> startTask(@PathVariable Integer id){
		Task task=taskService.startTask(id);
		TaskResponseDto response= Mapper.taskToResponseDto(task);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@PatchMapping("/complete/{id}")
	public ResponseEntity<TaskResponseDto> completeTask(@PathVariable Integer id){
		
		Task task=taskService.completeTask(id);
		TaskResponseDto response= Mapper.taskToResponseDto(task);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
