package com.spring.employee_management_system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.employee_management_system.dto.RegisterRequest;
import com.spring.employee_management_system.entity.User;
import com.spring.employee_management_system.repository.UserRepository;
import com.spring.employee_management_system.util.OtpGenerator;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private EmailService emailService;
	private PasswordEncoder passwordEncoder;

	
	
	public UserService(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}

	public String register(RegisterRequest registerRequest)
	{
		Optional<User> ou = userRepository.findByEmail(registerRequest.getEmail());
		if(ou.isPresent())
		{
			return "email_id already exists";
		}
		else {
			User user = new User();
			user.setName(registerRequest.getName());
			user.setEmail(registerRequest.getEmail());
			user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
			user.setRole("USER_ROLE");
			user.setVerified(false);
			String otp = OtpGenerator.generateOtp();
			user.setOtp(otp);
			user.setOtpexpirytime(LocalDateTime.now().plusMinutes(5));
			userRepository.save(user);
			
			
			emailService.sendOtp(registerRequest.getEmail(), otp);
			return "Please check your email for OTP";
			
			
//			userRepository.save(user);
//			return "Please enter otp";

		}
	}

}
