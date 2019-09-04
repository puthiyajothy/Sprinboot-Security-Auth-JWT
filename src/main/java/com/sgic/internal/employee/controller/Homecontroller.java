package com.sgic.internal.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {
	
	

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
		
	}
	
	@RequestMapping("/Login")
	public String loginpage() {
		return "Login.jsp";
		
	}
	@RequestMapping("/Logout")
	public String logout() {
		return "Logout.jsp";
		
	}
	
	

}
