package com.jems.serviceimpln;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jems.entity.Admin;
import com.jems.entity.Otptable;
import com.jems.repo.AdminRepo;
import com.jems.repo.OtpARepo;
import com.jems.service.AdminService;

@Service
public class AdminServiceimpln  implements AdminService{

	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	OtpARepo aRepo;
	@Override
	public String verifyEmail(String email) {
		Admin a=adminRepo.findByAemail(email);
		if(a==null) {
			return "not found";
		}
		else {
			SimpleMailMessage m=new SimpleMailMessage();
			
				int n=(int)(Math.random()*100000);
		
			m.setFrom("darshanqspiders08@gmail.com");
			m.setTo(a.getAemail());
			m.setSubject("OTP FOR PASSWORD RESET");
			m.setText("Hi "+a.getAname()+"\n Your OTP Is:"+n);
			
			aRepo.save(new Otptable(a.getAid(),n));
			javaMailSender.send(m);
			return "Otp Sent "+n;
		}
		
	}
	@Override
	public String changePassword(String email, int otp, String pswd) {
		Admin a=adminRepo.findByAemail(email);
		Otptable t = aRepo.findById(a.getAid()).orElse(null);
		if(t.getOtp()==otp) {
			a.setApswd(pswd);
			adminRepo.save(a);
			aRepo.deleteById(a.getAid());
			return "Password Changed...!!";
		}
		else {
			return "invalid Otp";
		}
	}

}