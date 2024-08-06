package com.ckael.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckael.taskmanager.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	Optional<RoleEntity> findByRoleName(String roleName);
}
