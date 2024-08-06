package com.ckael.taskmanager.service;

import java.util.List;

import com.ckael.taskmanager.model.RoleEntity;

public interface RoleService {
	RoleEntity addRole(RoleEntity r);
	RoleEntity updateRole(RoleEntity r);
	void deleteRole(RoleEntity r);
	void deleteRole(int id);
	List<RoleEntity> listRoles();
	
}
