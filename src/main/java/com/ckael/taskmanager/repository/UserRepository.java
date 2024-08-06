package com.ckael.taskmanager.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckael.taskmanager.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findByUserName(String userName);
	Boolean existsByUserName(String userName);
	Boolean existsByUserMail(String userMail);
}
