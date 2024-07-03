package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private int pid;
	private String pname;
	private String company;
	private double price;
	private String color;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Product(int pid, String pname, String company, double price, String color) {
		this.pid = pid;
		this.pname = pname;
		this.company = company;
		this.price = price;
		this.color = color;
	}
	
	public Product() {
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", company=" + company + ", price=" + price + ", color="
				+ color + "]";
	}
	
	
}
