package com.springbootTSM.task_management_system.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootTSM.task_management_system.dto.request.UserRequestDto;
import com.springbootTSM.task_management_system.dto.response.UserResponseDto;
import com.springbootTSM.task_management_system.entity.User;
import com.springbootTSM.task_management_system.mapper.Mapper;
import com.springbootTSM.task_management_system.repository.UserRepository;

@Service
public class UserServieImpl implements UserService {

	UserRepository repository;
	PasswordEncoder passwordEncoder;
	
	public UserServieImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserResponseDto save(UserRequestDto dto) {
		
		User user=Mapper.userRequestDtoToUSerEntity(dto);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repository.save(user);
		
		return Mapper.userEntityToUserResponseDto(user);
	}

}
