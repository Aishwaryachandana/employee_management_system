package com.spring.employee_management_system.util;

import java.util.Random;

public class OtpGenerator {
	
	public static String generateOtp()
	{
		Random random=new Random();
		int otp = 100000 + random.nextInt(900000);  //6 digit otp
		return String.valueOf(otp);
	}
	

}
