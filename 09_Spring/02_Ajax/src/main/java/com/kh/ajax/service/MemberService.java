package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.mapper.MemberMapper;
import com.kh.ajax.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	public Member idCheck(String id) {
		return mapper.idCheck(id);
	}
	
	public boolean idBoolCheck(String id) {
		return mapper.idBoolCheck(id);
	}
	
	public void register(Member vo) {
		mapper.register(vo);
	}
}
