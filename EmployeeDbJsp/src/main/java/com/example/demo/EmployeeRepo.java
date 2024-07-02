package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee,String> {

	List<Employee> findByAge(int age);
	
	@Query(nativeQuery=true,value="select * from employee where age >=?1 and age<=?2")
	List<Employee> findByBwAge(int age1,int age2);
	
	@Query(nativeQuery=true,value="select * from employee where eid=?1 or email=?2")
	Employee findByEidOrEmail(String value1,String value2);
}
