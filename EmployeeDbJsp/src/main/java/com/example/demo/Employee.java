package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private String eid;
	private String ename;
	private double sal;
	private int age;
	private String design;
	private String email;
	
	
	
	public Employee(String eid, String ename, double sal, int age, String design, String email) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.age = age;
		this.design = design;
		this.email = email;
	}


	

	public String getEid() {
		return eid;
	}




	public void setEid(String eid) {
		this.eid = eid;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
   
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getDesign() {
		return design;
	}


	public void setDesign(String design) {
		this.design = design;
	}




	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", age=" + age + ", design=" + design
				+ ", email=" + email + "]";
	}


	
	
}
