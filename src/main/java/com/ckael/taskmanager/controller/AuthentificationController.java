package com.ckael.taskmanager.controller;

import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckael.taskmanager.model.LoginEntity;
import com.ckael.taskmanager.model.RoleEntity;
import com.ckael.taskmanager.model.UserEntity;
import com.ckael.taskmanager.repository.RoleRepository;
import com.ckael.taskmanager.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Auth")
public class AuthentificationController {
	
	
	
	@Autowired
	private RoleRepository roleRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/Register")
	public ResponseEntity<String> register(@Valid @RequestBody UserEntity user)
	{
		if(userRep.existsByUserName(user.getUserName())) 
		{
			return new ResponseEntity<>("User name "+user.getUserName()+"\nalready exist",HttpStatus.BAD_REQUEST);
		}
		if(userRep.existsByUserMail(user.getUserMail())) 
		{
			return new ResponseEntity<>("User E-mail "+user.getUserMail()+"\n already exist",HttpStatus.BAD_REQUEST);
		}
		String pass = user.getUserPassword();
		user.setUserPassword(passwordEncoder.encode(pass));
		
		RoleEntity role = roleRep.findByRoleName("USER").get();
		
		user.setUserRoles(Collections.singletonList(role));
			
		userRep.save(user);
		return new ResponseEntity<>("Registered with success",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<String> login(@RequestBody LoginEntity user)
	{
		Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPassword())
				);
				SecurityContextHolder.getContext().setAuthentication(auth);
		return new ResponseEntity<>("Login with success",HttpStatus.OK);
	}

}
