package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.mapper.FilmMapper;
import com.kh.paging.model.dto.PagingDTO;
import com.kh.paging.model.vo.Film;

@Service
public class FilmService {
	
	@Autowired
	private FilmMapper mapper;
	
	public List<Film> showFilm(PagingDTO paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		return mapper.showFilm(paging);
	}
	
	public int total() {
		return mapper.total();
	}
}
