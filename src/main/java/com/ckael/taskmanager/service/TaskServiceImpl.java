package com.ckael.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckael.taskmanager.exception.NotFound;
import com.ckael.taskmanager.model.Task;
import com.ckael.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository Rep;

	@Override
	public Task addTask(Task t) {
		
		return Rep.save(t);
	}

	@Override
	public Task editTask(Task t) {
		
		return Rep.save(t);
	}

	@Override
	public void deleteTask(Long Id) {
		Rep.deleteById(Id);
		
	}

	@Override
	public void deleteTask(Task t) {
		Rep.delete(t);
		
	}

	@Override
	public List<Task> listTasks() {
		
		return Rep.findAll();
	}

	@Override
	public Task findById(Long Id) throws NotFound {
		
		return Rep.findById(Id).orElseThrow(()->new NotFound("Task not found"));
	}

}
