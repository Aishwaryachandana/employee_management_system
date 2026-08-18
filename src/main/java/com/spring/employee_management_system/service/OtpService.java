package com.spring.employee_management_system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.employee_management_system.dto.VerifyOtpRequest;
import com.spring.employee_management_system.entity.User;
import com.spring.employee_management_system.exception.InvalidOtpException;
import com.spring.employee_management_system.exception.UserNotFoundException;
import com.spring.employee_management_system.repository.UserRepository;

@Service
public class OtpService {
	
	private UserRepository userRepository;

	public OtpService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public String VerifyOtp(VerifyOtpRequest verifyOtpRequest)
	{
		Optional<User> optionaluser = userRepository.findByEmail(verifyOtpRequest.getEmail());
		if(optionaluser.isPresent()) {
			User user=optionaluser.get();
			
			if(user.getOtp()==null)	
			{
				throw new InvalidOtpException("Otp already verified");
			}
				
				
		 
			
			
		if(!user.getOtp().equals(verifyOtpRequest.getOtp()))
		{
			throw new InvalidOtpException ("invalid otp");
		}
		
		if(LocalDateTime.now().isAfter(user.getOtpexpirytime()))
		{
			return "otp expired";
		}
		
		else {
			user.setVerified(true);
			user.setOtp(null);
			user.setOtpexpirytime(null);
			userRepository.save(user);   //updating existing object
			return "otp verified successfully";
		}
		}
		
		else {
			throw new UserNotFoundException("no user found");
		}
		
	}
	
	

}
