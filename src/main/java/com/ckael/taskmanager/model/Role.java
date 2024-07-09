package com.ckael.taskmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Role_Id;
	
	@Column
	@NotBlank(message="Role name must be not null")
	private String Role_name;

	public int getRole_Id() {
		return Role_Id;
	}

	public void setRole_Id(int role_Id) {
		Role_Id = role_Id;
	}

	public String getRole_name() {
		return Role_name;
	}

	public void setRole_name(String role_name) {
		Role_name = role_name;
	}
	
	

}
