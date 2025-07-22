package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.model.dto.PagingDTO;
import com.kh.paging.model.vo.Film;
import com.kh.paging.service.FilmService;

@Controller
public class FilmController {
	
	@Autowired
	private FilmService service;
	
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
		List<Film> list = service.showFilm(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		return "list";
	}
}
