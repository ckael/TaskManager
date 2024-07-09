package com.ckael.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckael.taskmanager.exception.NotFound;
import com.ckael.taskmanager.model.Role;
import com.ckael.taskmanager.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository rep;
	@Override
	public Role addRole(Role r) {
		
		return rep.save(r);
	}

	@Override
	public Role updateRole(Role r) {
		
		return rep.save(r);
	}

	@Override
	public void deleteRole(Role r) {
		rep.delete(r);

	}

	@Override
	public void deleteRole(int id) {
		rep.deleteById(id);

	}

	@Override
	public List<Role> listRoles() {
		
		return rep.findAll();
	}

	@Override
	public Role findByName(String name) throws NotFound{
		
		return rep.findByRole_name(name).orElseThrow(()->new NotFound("Role not found"));
	}

}
