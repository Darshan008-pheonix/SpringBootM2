package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private int eid;
	private String ename;
	private double sal;
	private int age;
	private String design;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int eid, String ename, double sal, int age, String design) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.age = age;
		this.design = design;
	}
   
	
	
	

	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
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
				+ "]";
	}
	
}
