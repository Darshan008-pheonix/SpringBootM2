package com.jems.service;

public interface AdminService {

	String verifyEmail(String email);
	String changePassword(String email,int otp,String pswd);
	
}

