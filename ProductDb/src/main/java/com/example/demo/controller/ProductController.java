package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService; 
	
	@PostMapping("savePro")
	ResponseEntity<Product> addPro(@RequestBody Product p) {
		return new ResponseEntity<Product>(productService.addPro(p),HttpStatus.CREATED);
	}
}
