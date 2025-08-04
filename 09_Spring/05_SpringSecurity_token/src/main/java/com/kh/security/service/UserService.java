package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService{
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder bcpe;
	
	public void register(User vo) {
//		System.out.println("암호화 전 : " + vo.getPwd());		
//		System.out.println("암호화 후 : " + bcpe.encode(vo.getPwd()));
		vo.setPwd(bcpe.encode(vo.getPwd()));
		if(vo.getId().equals("admin")) {
			vo.setRole("ROLE_ADMIN");
		} else {
			vo.setRole("ROLE_USER");
		}
		
		mapper.register(vo);
	}

	public User login(User vo) {
		User user = mapper.login(vo.getId());	
		if(user!=null && bcpe.matches(vo.getPwd(), user.getPwd())) {
			System.out.println("로그인 성공");
			return user;
		}
		return null;
	}
	
	
}
