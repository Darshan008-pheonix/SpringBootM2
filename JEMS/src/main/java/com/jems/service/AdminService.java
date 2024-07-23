package com.jems.service;

import com.jems.entity.Admin;

public interface AdminService {

	String verifyEmail(String email);
	String changePassword(String email,int otp,String pswd);
	Admin addAdmin(Admin a);
	Admin addLogin(int aid, String pswd);
	
}

