package com.jems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
}
