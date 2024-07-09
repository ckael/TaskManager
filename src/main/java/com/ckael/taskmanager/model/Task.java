package com.ckael.taskmanager.model;



import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Task_id;
	
	@Column
	@NotBlank(message = "Task name must be not null")
	@Min(5)
	@Max(30)
	private String Task_name;
	
	@Column
	@NotBlank(message = "Task details must be not null")
	@Min(10)
	private String Task_details;
	
	@Column
	@NotBlank(message = "Task time is null")
	private Date Task_time;
	
	@Column
	private Date Checked_time;
	
	@Column
	@NotBlank(message = "Is checked???")
	private Boolean Is_checked;

	public Long getTask_id() {
		return Task_id;
	}

	public void setTask_id(Long task_id) {
		Task_id = task_id;
	}

	public String getTask_name() {
		return Task_name;
	}

	public void setTask_name(String task_name) {
		Task_name = task_name;
	}

	public String getTask_details() {
		return Task_details;
	}

	public void setTask_details(String task_details) {
		Task_details = task_details;
	}

	public Date getTask_time() {
		return Task_time;
	}

	public void setTask_time(Date task_time) {
		Task_time = task_time;
	}

	public Date getChecked_time() {
		return Checked_time;
	}

	public void setChecked_time(Date checked_time) {
		Checked_time = checked_time;
	}

	public Boolean getIs_checked() {
		return Is_checked;
	}

	public void setIs_checked(Boolean is_checked) {
		Is_checked = is_checked;
	}
	
	
	

}
