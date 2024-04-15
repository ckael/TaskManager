package com.ckael.taskmanager.exception.messagemodel;

public class NotFoundMessage {

	private String message;
	private int code ;
	private String type ;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public NotFoundMessage(String message, int code, String type) {
		super();
		this.message = message;
		this.code = code;
		this.type = type;
	}
	
}
