package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		
		// 로그인을 했는지 안했는지
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("component", "../component/main.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/projectView")
	public String projectView() {
		return "";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/page/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/page/register";
	}
	
	@GetMapping("/example")
	public String example(Model model) {
		model.addAttribute("component", "../component/example.jsp");
		return "/common/layout";
	}
}
