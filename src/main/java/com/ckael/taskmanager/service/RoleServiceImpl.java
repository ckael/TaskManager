package com.ckael.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckael.taskmanager.exception.NotFound;
import com.ckael.taskmanager.model.RoleEntity;
import com.ckael.taskmanager.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository rep;
	@Override
	public RoleEntity addRole(RoleEntity r) {
		
		return rep.save(r);
	}

	@Override
	public RoleEntity updateRole(RoleEntity r) {
		
		return rep.save(r);
	}

	@Override
	public void deleteRole(RoleEntity r) {
		rep.delete(r);

	}

	@Override
	public void deleteRole(int id) {
		rep.deleteById(id);

	}

	@Override
	public List<RoleEntity> listRoles() {
		
		return rep.findAll();
	}

	

}
