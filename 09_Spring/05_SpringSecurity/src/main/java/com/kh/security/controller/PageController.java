package com.kh.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping("/login")
	public void login() {}
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
//	
//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}
//	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
}
