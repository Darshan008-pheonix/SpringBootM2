package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;


public interface ProductRepo extends JpaRepository<Product,Integer> {
	
	@Query(nativeQuery = true,value="select * from product order by price")
	List<Product> buyPriceLowToHigh(); 
} 
