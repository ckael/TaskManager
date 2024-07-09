package com.ckael.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckael.taskmanager.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRole_name(String name);
}
