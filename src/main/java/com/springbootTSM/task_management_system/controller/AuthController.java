package com.springbootTSM.task_management_system.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootTSM.task_management_system.dto.request.LoginRequestDto;
import com.springbootTSM.task_management_system.dto.request.UserRequestDto;
import com.springbootTSM.task_management_system.dto.response.LoginResponseDto;
import com.springbootTSM.task_management_system.dto.response.UserResponseDto;
import com.springbootTSM.task_management_system.security.JwtService;
import com.springbootTSM.task_management_system.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	UserService service;
	JwtService jwtService;

	private final AuthenticationManager authenticationManager;
	
	public AuthController(UserService service, JwtService jwtService, AuthenticationManager authenticationManager) {
		
		this.service = service;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto dto){
		
		return ResponseEntity.ok(service.save(dto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> logIn(@RequestBody LoginRequestDto dto){
		
		
		
		Authentication authentication= authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
				);
		
		
		UserDetails userdetails=(UserDetails)authentication.getPrincipal();
		
		String token=jwtService.generateToken(userdetails);
		
		LoginResponseDto response=new LoginResponseDto();
		
		response.setToken(token);
		response.setUsername(userdetails.getUsername());
		
		return ResponseEntity.ok(response);
		
	}
	
	
}
