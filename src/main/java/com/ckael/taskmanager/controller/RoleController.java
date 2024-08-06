package com.ckael.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckael.taskmanager.model.RoleEntity;
import com.ckael.taskmanager.service.RoleServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Role")
public class RoleController {

	@Autowired 
	RoleServiceImpl service ; 
	
	@PostMapping("/addRole")
	public ResponseEntity<RoleEntity> addRole(@Valid @RequestBody RoleEntity r)
	{	
		return new ResponseEntity<>(service.addRole(r),HttpStatus.CREATED);
	}
	
	@PostMapping("/editRole")
	public ResponseEntity<RoleEntity> editRole(@Valid @RequestBody RoleEntity r)
	{
		RoleEntity role = service.updateRole(r);
		return ResponseEntity.ok(role);
	}
	
	@PutMapping("/deleteRole/{Id}")
	public ResponseEntity<Object> deleteRole(@PathVariable int Id , @Valid @RequestBody RoleEntity r)
	{
		if(r.equals(null)) 
		{
			service.deleteRole(Id);
		}
		service.deleteRole(r);
		return ResponseEntity.ok("Role deleted with success");
	}
	
	@GetMapping("/listRoles")
	public ResponseEntity<List<RoleEntity>> listRoles()
	{
		return ResponseEntity.ok(service.listRoles());
	}
	
}
