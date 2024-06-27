package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("main")
	String welcome() {
		return "Welcome.jsp";
	}
	
	@RequestMapping("addEmp")
	String addEmp(Employee e,HttpSession h1 ) {
		repo.save(e);
		h1.setAttribute("msg", e.getEname()+" had been added into Db...!!!!");
		return "AddEmply.jsp";
		
	}
}
