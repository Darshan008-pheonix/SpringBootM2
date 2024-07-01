package com.example.demo;

import java.util.Optional;

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
	
	@RequestMapping("removeEmp")
	String removeEmp(int eid,HttpSession h1 ) {
		Employee e=repo.findById(eid).orElse(null);
		if(e!=null) {
			repo.deleteById(eid);  
			h1.setAttribute("value",e.getEname()+" had been removed....!!!");
		}
		else {
			h1.setAttribute("value","Invalid Eid .....!!!!!");
		}
		return "RemoveEmp.jsp";
		
	}
	
	@RequestMapping("EmpById")
	String empById(int eid ,HttpSession h1) {
		Employee e=repo.findById(eid).orElse(null);
		if(e!=null) { 
			h1.setAttribute("info",e);
		}
		else {
			h1.setAttribute("info","Invalid Eid .....!!!!!");
		}
		return "EmplyById.jsp";
	}

	
}
