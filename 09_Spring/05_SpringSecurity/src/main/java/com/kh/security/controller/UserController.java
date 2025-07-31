package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.model.vo.User;
import com.kh.security.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/register")
	public String register(User vo) {
		service.register(vo);
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(User vo, HttpServletRequest request) {
		User user = service.login(vo.getId());
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return "redirect:/";
	}
}
