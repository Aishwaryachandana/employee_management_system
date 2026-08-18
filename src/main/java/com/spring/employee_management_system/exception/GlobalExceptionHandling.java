package com.spring.employee_management_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> invalidData(MethodArgumentNotValidException exception)
	{
		Map<String, String> message=new HashMap<String, String>();
		
		List<FieldError> errors=exception.getBindingResult().getFieldErrors();
		 
		for(FieldError fe : errors)
		{
			message.put(fe.getField(), fe.getDefaultMessage());
		}
//	    String message = exception.getBindingResult().getFieldErrors().getDefaultMessage();
		return new ResponseEntity<Map<String,String>>(message,HttpStatus.BAD_REQUEST);	
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> invalidData(MethodArgumentNotValidException exception) {
//	    Map<String, String> errors = new HashMap<>();
//
//	    exception.getBindingResult().getFieldErrors().forEach(error -> 
//	        errors.put(error.getField(), error.getDefaultMessage())
//	    );
//
//	    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
		
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException userNotFoundException)
	{
		return new ResponseEntity<String>(userNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtp(InvalidOtpException invalidOtpException)
	{
		return new ResponseEntity<String>(invalidOtpException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<String> otpExpiredException(OtpExpiredException otpExpiredException)
	{
		return new ResponseEntity<String>(otpExpiredException.getMessage(),HttpStatus.GONE);
	}
	
	
	@ExceptionHandler(OtpVerifiedException.class)
	public ResponseEntity<String> otpVerified(OtpVerifiedException otpVerifiedException)
	{
		return new ResponseEntity<String>(otpVerifiedException.getMessage(),HttpStatus.OK);
	}
	
	
	
	@ExceptionHandler(OtpAlreadyVerified.class)
	public ResponseEntity<String> otpAlreadyVerified(OtpAlreadyVerified otpAlreadyVerified)
	{
		return new ResponseEntity<String>(otpAlreadyVerified.getMessage(),HttpStatus.ACCEPTED);
	}
	
	

}
