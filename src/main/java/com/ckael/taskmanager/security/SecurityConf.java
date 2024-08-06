package com.ckael.taskmanager.security;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ckael.taskmanager.service.UserServiceImpl;

@Configuration
public class SecurityConf {
	
	@Autowired
	UserServiceImpl service;
	
	@Bean
	public SecurityFilterChain securisationApi(HttpSecurity http) throws Exception 
	{
		http.csrf().disable().authorizeHttpRequests
		((auth)->auth.requestMatchers("/Auth/**")
					.permitAll()
					.requestMatchers(HttpMethod.GET)
					.permitAll()
					.requestMatchers("/user/**")
					.hasRole("ADMIN")
					
										
										).httpBasic();
		
		return http.build();
	}
	
	@Bean
	AuthenticationManager authManager(AuthenticationConfiguration authConfiguration) throws Exception{	
		
		return authConfiguration.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	
}	
