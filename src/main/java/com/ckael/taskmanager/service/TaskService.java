package com.ckael.taskmanager.service;

import java.util.List;

import com.ckael.taskmanager.model.Task;

public interface TaskService {
 
	Task addTask(Task t);
	Task editTask(Task t);
	void deleteTask(Long Id);
	void deleteTask(Task t);
	List<Task> listTasks();
		
}
