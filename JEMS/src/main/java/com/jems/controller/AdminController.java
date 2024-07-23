package com.jems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jems.entity.Admin;
import com.jems.service.AdminService;


import jakarta.persistence.Entity;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("verfiyEmail")
	ResponseEntity verifyEmail( @RequestHeader String Email) {

	return new ResponseEntity(adminService.verifyEmail(Email),HttpStatus.ACCEPTED);
	}

	@GetMapping("changePswd")
	ResponseEntity changePassword( @RequestHeader String email,@RequestHeader int otp,@RequestHeader String pswd) {

	return new ResponseEntity(adminService.changePassword(email, otp, pswd),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("addAdmin")
	ResponseEntity<Admin> addAdmin(@RequestBody Admin a){
		System.out.println(a);
		return new ResponseEntity<Admin>(adminService.addAdmin(a),HttpStatus.ACCEPTED);
		
	}
	
	
	@PostMapping("adminLogin")
	ResponseEntity<Admin> adminLogin(@RequestHeader int aid,@RequestHeader String pswd){
		return new ResponseEntity<Admin>(adminService.addLogin(aid,pswd),HttpStatus.FOUND);
		
	}
	
	
	@RequestMapping("disp")
	String display() {
		return "hello hi";
	}
}
