package com.kh.upload.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;

@Service
public class BoardService{
	
	@Autowired
	private BoardMapper mapper;
	
	public void insert(Board board) {
		mapper.insert(board);
	}
	
	public List<BoardDTO> selectAll(){
		List<Board> list = mapper.selectAll();
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board b : list) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(b.getNo());
			dto.setTitle(b.getTitle());
			Date date = Date.from(b.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setCreatedAt(date);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public BoardDTO select(int no) {
		Board board = mapper.select(no);
		BoardDTO dto = new BoardDTO();
		dto.setNo(board.getNo());
		dto.setTitle(board.getTitle());
		dto.setContent(board.getContent());
		dto.setUrl(board.getUrl());
		Date date = Date.from(board.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
		dto.setCreatedAt(date);
//		return mapper.select(no);
		return dto;
	}

	public void update(Board vo) {
		mapper.update(vo);
	}

	public void delete(int no) {
		mapper.delete(no);
	}
}
