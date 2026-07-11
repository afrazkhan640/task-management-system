package com.springbootTSM.task_management_system.service;

import org.springframework.stereotype.Service;

import com.springbootTSM.task_management_system.dto.request.UserRequestDto;
import com.springbootTSM.task_management_system.dto.response.UserResponseDto;

@Service
public interface UserService {

	public UserResponseDto save(UserRequestDto dto);
}
