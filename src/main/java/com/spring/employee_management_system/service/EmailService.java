package com.spring.employee_management_system.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	private final JavaMailSender javaMailSender;
	
public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendOtp(String toEmail,String otp)
	{
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject("OTP Verification");
		simpleMailMessage.setText("Your OTP is "+" "+ otp);
		javaMailSender.send(simpleMailMessage);
	}
	}

