package com.ckael.taskmanager.service;

import java.util.List;

import com.ckael.taskmanager.model.Role;

public interface RoleService {
	Role addRole(Role r);
	Role updateRole(Role r);
	void deleteRole(Role r);
	void deleteRole(int id);
	List<Role> listRoles();
	Role findByName(String name);
}
