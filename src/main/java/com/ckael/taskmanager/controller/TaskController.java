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

import com.ckael.taskmanager.model.Task;
import com.ckael.taskmanager.service.TaskService;

import jakarta.validation.Valid;


@RequestMapping("/Task")
@RestController
public class TaskController {
	
	@Autowired
	TaskService service;
	
	@PostMapping("/addTask")
	public ResponseEntity<Task> addTask(@Valid @RequestBody Task t)
	{
		Task task = service.addTask(t);
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@PostMapping("/editTask")
	public ResponseEntity<Task> editTask(@Valid @RequestBody Task t)
	{
		Task task = service.editTask(t);
		
		return ResponseEntity.accepted().body(task);
	}
	
	@PutMapping("/deleteTask/{Id}")
	public ResponseEntity<Object> deleteTask(@PathVariable Long Id ,@Valid @RequestBody Task t)
	{
		if(Id.equals(null)) {
			service.deleteTask(t);
		}
		service.deleteTask(Id);
		return ResponseEntity.ok("Task deleted with id : "+Id+"success");
	}
	
	
	@GetMapping("/listTasks")
	public ResponseEntity<List<Task>> listTasks()
	{
		return ResponseEntity.ok(service.listTasks());		
	}
	
	

}
