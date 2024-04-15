package com.ckael.taskmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckael.taskmanager.model.Task;
import com.ckael.taskmanager.service.TaskServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaskController {
	@Autowired
	TaskServiceImpl service;
	
	@PostMapping("/Task")
	public ResponseEntity<Task> addTask(@RequestBody() Task t)
	{	
		return new ResponseEntity<>(service.addTask(t),HttpStatus.CREATED);	
	}
	@DeleteMapping("/Task/{Id}")
	public ResponseEntity<String> deleteTask(@PathVariable int Id)
	{
		service.DeleteTask(Id);		
		return ResponseEntity.ok("Task"+Id+"Deleted with success") ;
	}
	@GetMapping("/Task/{Id}")
	public ResponseEntity<Task> findTaskById(@PathVariable int Id)
	{
		Task t = service.getTaskById(Id);
		return ResponseEntity.ok(t);
	}
	@GetMapping("/Task")
	public ResponseEntity<List<Task>> findAllTask()
	{
		List<Task> tl = service.getAllTask();
		return ResponseEntity.ok(tl);
	}
	@PutMapping("/Task")
	public ResponseEntity<Task> updateTask(@RequestBody() Task t)
	{
		service.updateTask(t);
		
		return ResponseEntity.ok(t);
	}
	
	

}
