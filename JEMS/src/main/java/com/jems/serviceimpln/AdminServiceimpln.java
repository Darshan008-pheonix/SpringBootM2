package com.jems.serviceimpln;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jems.entity.Admin;
import com.jems.entity.Otptable;
import com.jems.exception.InvalidEmailException;
import com.jems.exception.InvalidOtpException;
import com.jems.repo.AdminRepo;
import com.jems.repo.OtpARepo;
import com.jems.service.AdminService;

@Service
public class AdminServiceimpln  implements AdminService{

	
	BCryptPasswordEncoder b1=new BCryptPasswordEncoder();
	
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
			throw new InvalidEmailException();
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
		Otptable t = aRepo.findById(a.getAid()).orElseThrow(()->new InvalidEmailException());
		if(t.getOtp()==otp) {
			a.setApswd(pswd);
			adminRepo.save(a);
			aRepo.deleteById(a.getAid());
			return "Password Changed...!!";
		}
		else {
			throw new InvalidOtpException();
		}
	}
	@Override
	public Admin addAdmin(Admin a) {
		a.setApswd(b1.encode(a.getApswd()));
		return adminRepo.save(a);
	}
	@Override
	public Admin addLogin(int aid, String pswd) {
		Admin a=adminRepo.findById(aid).orElseThrow(()->new InvalidEmailException());
		if(b1.matches(pswd,a.getApswd())) {
			return a;
		}
		throw new InvalidOtpException();
	}

}
