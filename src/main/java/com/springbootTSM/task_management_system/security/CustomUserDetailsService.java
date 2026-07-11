package com.springbootTSM.task_management_system.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootTSM.task_management_system.entity.User;
import com.springbootTSM.task_management_system.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
	UserRepository repository;
	
	public CustomUserDetailsService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=repository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("user not found"));
		
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
		}
}
