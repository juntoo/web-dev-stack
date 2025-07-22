package com.project.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.erp.model.vo.UserInfo;
import com.project.erp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/insert")
	public String insert(UserInfo user) {
		userService.addUser(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list() {
		List<UserInfo> list = userService.viewUser();
		System.out.println(list);
		return "redirect:/";
	}
}
