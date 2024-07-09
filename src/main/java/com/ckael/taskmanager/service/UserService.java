package com.ckael.taskmanager.service;

import java.util.List;

import com.ckael.taskmanager.model.UserEntity;

public interface UserService {

	UserEntity saveUser(UserEntity u);
	UserEntity editUser(UserEntity u);
	void deleteUser(String Id);
	void deleteUser(UserEntity u);
	List<UserEntity> listUsers();
}
