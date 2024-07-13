package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	static final Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService; 
	
	@PostMapping("savePro")
	ResponseEntity<Product> addPro(@RequestBody Product p) {
		logger.info("Save Product Api had been called....!!");
		return new ResponseEntity<Product>(productService.addPro(p),HttpStatus.CREATED);
	}
	
	@GetMapping("byID")
	ResponseEntity<Product> proById(@RequestHeader int pid) {
		return new ResponseEntity<Product>(productService.findPro(pid),HttpStatus.FOUND);
	}
}

