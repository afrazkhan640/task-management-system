package com.springbootTSM.task_management_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		
		
		
//		http.authorizeHttpRequests(
//				auth->auth.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//		
//		return http.build(); -> First Learned....(1)
		
		
//	public UserDetailsService userDetailService() {
//		
//		UserDetails user=User.withUsername("afraz")
//				.password("{noop}1234")
//				.roles("USER").build();
//		
//		UserDetails admin=User.withUsername("admin")
//				.password("{noop}1234")
//				.roles("ADMIN").build();
//		
//		return new InMemoryUserDetailsManager(user,admin); -->2nd Learned....(2)
//	}
		
		
		http
	    .csrf(csrf -> csrf.disable())
	    .authorizeHttpRequests(auth -> auth
	    		.requestMatchers("/auth/register").permitAll()
	    		.requestMatchers("/auth/login").permitAll()
	    		.requestMatchers("/task/**").permitAll()
	        .requestMatchers("/admin/**").hasRole("ADMIN")
	        .requestMatchers("/user/**").hasRole("USER")
	        .anyRequest().authenticated())
	    .httpBasic(Customizer.withDefaults());
		
		http.addFilterBefore(
		        jwtAuthenticationFilter,
		        UsernamePasswordAuthenticationFilter.class
		);
		
		return http.build();
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration configuration) throws Exception{
		
		return configuration.getAuthenticationManager();
	}
}
