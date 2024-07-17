package com.jems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jems.entity.Otptable;

public interface OtpARepo extends JpaRepository<Otptable, Integer> {

}
