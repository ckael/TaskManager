package com.ckael.taskmanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> ArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errs = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errs.put(error.getField(), error.getDefaultMessage()));
		
		return new ResponseEntity<>(errs,new HttpHeaders(),HttpStatus.UNPROCESSABLE_ENTITY);		
	}

}
