package com.springbootTSM.task_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootTSM.task_management_system.dto.request.UserRequestDto;
import com.springbootTSM.task_management_system.dto.response.UserResponseDto;
import com.springbootTSM.task_management_system.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	
	@GetMapping("/profile")
	public String profile() {
		
		return "Login Successfully";
	}
	
	
}
