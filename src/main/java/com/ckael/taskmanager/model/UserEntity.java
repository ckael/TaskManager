package com.ckael.taskmanager.model;




import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "User")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String User_id;

	@Column
	@NotBlank(message="user name must be not null")
	@Min(5)
	@Max(15)
	private String User_name;
	
	@Column
	@NotBlank(message="user mail must be not null")
	@Email
	private String User_mail;
	
	@Column
	@NotBlank(message="Insert password")
	@Min(8)
	private String User_password;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "User_id")
	private List<Task> Tasks ; 
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "User_Role",joinColumns = @JoinColumn(name="User_id",referencedColumnName = "User_id"),
	inverseJoinColumns = @JoinColumn(name = "Role_id",referencedColumnName = "Role_id") )
	private List<Role> User_Roles = new ArrayList<>();
	

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getUser_mail() {
		return User_mail;
	}

	public void setUser_mail(String user_mail) {
		User_mail = user_mail;
	}

	public String getUser_password() {
		return User_password;
	}

	public void setUser_password(String user_password) {
		User_password = user_password;
	}

	public List<Task> getTasks() {
		return Tasks;
	}

	public void setTasks(List<Task> tasks) {
		Tasks = tasks;
	}

	public List<Role> getUser_Roles() {
		return User_Roles;
	}

	public void setUser_Roles(List<Role> user_Roles) {
		User_Roles = user_Roles;
	}
	
	
}
