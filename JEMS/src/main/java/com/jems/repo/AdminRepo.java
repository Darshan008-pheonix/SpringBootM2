package com.jems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jems.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{

	Admin findByAemail(String email);
}
