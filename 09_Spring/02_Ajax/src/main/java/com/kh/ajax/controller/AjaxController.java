package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;


@Controller
public class AjaxController {

    private final PageController pageController;
	
	@Autowired
	private MemberService service;
	
	private int count = 0;

    AjaxController(PageController pageController) {
        this.pageController = pageController;
    }
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax 요청");
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		return nickname;
	}
	
	@ResponseBody
	@PostMapping("/check")
	public boolean idCheck(String id) {
//		if(service.idCheck(id) != null) {
//			return true;
//		}
//		return false;
		return service.idBoolCheck(id);
	}
	
	@ResponseBody
	@PostMapping("/signup")
	public Member signup(Member vo) {
		service.register(vo);
		return vo;
	}
	
	@ResponseBody
	@PostMapping("/register")
	public Member register(Member vo) {
		System.out.println(vo);
		return vo;
	}
}
