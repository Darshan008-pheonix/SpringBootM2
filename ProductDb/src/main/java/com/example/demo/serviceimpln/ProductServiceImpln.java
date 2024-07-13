package com.example.demo.serviceimpln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpln implements ProductService{

	@Autowired
	ProductRepo productRepo; 
	
	@Override
	public Product addPro(Product p) {
		return productRepo.save(p);
	}

	@Override
	public Product findPro(int pid) {
		Product p=productRepo.findById(pid).orElseThrow(()->new ProductNotFoundException());
		return p;
	}

}
