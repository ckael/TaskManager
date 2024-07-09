package com.ckael.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckael.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
