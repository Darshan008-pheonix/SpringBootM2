package com.example.demo.service;

import com.example.demo.entity.Product;

public interface ProductService {

	Product addPro(Product p);
	Product findPro(int pid);
}
