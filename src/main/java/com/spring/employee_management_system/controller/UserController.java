package com.spring.employee_management_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee_management_system.dto.RegisterRequest;
import com.spring.employee_management_system.dto.VerifyOtpRequest;
import com.spring.employee_management_system.service.OtpService;
import com.spring.employee_management_system.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	private OtpService otpService;
	
	
	public UserController(UserService userService, OtpService otpService) {
		this.userService = userService;
		this.otpService = otpService;
	}

	@PostMapping("/register")
	private String register(@RequestBody RegisterRequest registerRequest)
	{
		return userService.register(registerRequest);
	}
	
	@PostMapping("/verify-otp")
	public String VerifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest)
	{
		return otpService.VerifyOtp(verifyOtpRequest);
	}

}
