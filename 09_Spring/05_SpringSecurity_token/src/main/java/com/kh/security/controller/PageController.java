package com.kh.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.security.model.vo.User;

@Controller
public class PageController {
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/logout")
	public void logout() {}
	
	@GetMapping("/mypage")
	public void mypage() {}
	
	@GetMapping("/admin")
	public void admin() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
//		model.addAttribute("user", user);
	}
	
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
