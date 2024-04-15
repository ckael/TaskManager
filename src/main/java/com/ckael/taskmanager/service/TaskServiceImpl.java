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
	public Task updateTask(Task t) {
		
		return Rep.save(t);
	}

	@Override
	public Task getTaskById(int Id) throws NotFound {
		
		return Rep.findById(Id).orElseThrow(()->new NotFound("Task not found"));
	}

	@Override
	public void DeleteTask(int Id) {
		
		Rep.deleteById(Id);
	}

	@Override
	public List<Task> getAllTask() {
		
		return Rep.findAll();
	}

	

	

}
