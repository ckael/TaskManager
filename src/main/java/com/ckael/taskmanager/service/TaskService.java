package com.ckael.taskmanager.service;

import java.util.List;


import com.ckael.taskmanager.model.Task;

public interface TaskService 
{
	Task addTask(Task t);
	Task updateTask(Task t);
	Task getTaskById(int Id);
	void DeleteTask(int Id);
	List<Task> getAllTask();
	
}

