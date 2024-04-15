package com.ckael.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ckael.taskmanager.exception.messagemodel.NotFoundMessage;

@ControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(NotFound.class)
	public ResponseEntity<Object> NotFoundEx(NotFound ex)	
	{
		NotFoundMessage Exception = new NotFoundMessage(ex.getMessage(),404,"Entity not found");
		
		return new ResponseEntity<>(Exception,HttpStatus.NOT_FOUND);
	}
	
	

}
