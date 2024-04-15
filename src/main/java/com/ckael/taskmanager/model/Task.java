package com.ckael.taskmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column 
	private boolean finish;
	
	@Column
	private boolean important;
	
	@Column 
	private String title;
	
	@Column
	private String description;
	
	@Column
	private String heure;
	
	
	
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	
	
	/**
	 * @param iD Identification of the task
	 * @param finish boolean who return if the task is finish or not 
	 * @param important boolean who return if the task is important
	 * @param title title of the task
	 * @param description of the task
	 * @param heure when the task is finished
	 */
	public Task(int id, boolean finish, boolean important, String title, String description, String heure) {
		super();
		this.id= id;
		this.finish = finish;
		this.important = important;
		this.title = title;
		this.description = description;
		this.heure = heure;
	}
	public Task() {

	}

	
	
	
	
	
	

}
