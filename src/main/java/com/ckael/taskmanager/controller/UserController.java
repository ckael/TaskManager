package com.ckael.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckael.taskmanager.model.UserEntity;
import com.ckael.taskmanager.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserEntity> saveUser(@Valid @RequestBody UserEntity u)
	{
		UserEntity user = service.saveUser(u);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@PostMapping("/editUser")
	public ResponseEntity<UserEntity> editUser(@Valid @RequestBody UserEntity u)
	{
		UserEntity user = service.editUser(u);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/deleteUser/{Id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String Id , @Valid @RequestBody UserEntity u)
	{
		if(u.equals(null))
		{
			service.deleteUser(Id);
		}
		service.deleteUser(u);
		
		return ResponseEntity.ok("User deleted with success");
	}
	
	@GetMapping("/listUsers")
	public ResponseEntity<List<UserEntity>> listUser()
	{
		return ResponseEntity.ok(service.listUsers());
	}

}
