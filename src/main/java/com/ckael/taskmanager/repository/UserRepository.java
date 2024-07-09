package com.ckael.taskmanager.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckael.taskmanager.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findByUser_name(String userName);
	Boolean exiexistsByUser_name(String userName);
}
