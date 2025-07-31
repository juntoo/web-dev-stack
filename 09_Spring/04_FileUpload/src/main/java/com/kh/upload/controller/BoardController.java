package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {
	
	private String path = "\\\\192.168.0.35\\upload\\";
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public String fileUpload(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
//		System.out.println(fileName);
		File copyFile = new File(path+fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public void fileDelete(String url) {
		File file = new File(path+url);
		if(file.exists()) {
			file.delete();
		}
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		System.out.println("파일 이름 : "+file.getOriginalFilename());
		System.out.println("파일 사이즈 : "+file.getSize());
		System.out.println("파일 파라미터명 : "+file.getName());
		
		// 중복 방지를 위한 UUID 적용
		String fileName = fileUpload(file);
		// http://localhost:8081/ + fileName <- url
		return "redirect:/";
	}
	
	// List<MultipartFile>
	@PostMapping("/multiUpload")
	public String multiUpload(@RequestParam("file")List<MultipartFile> files) {
		
		for(MultipartFile file : files) {
			String fileName = fileUpload(file);
			String url = fileName;
			Board board = new Board();
			board.setTitle(fileName);
			board.setContent(file.getContentType());
			board.setUrl(url);
			System.out.println(fileName);
			boardService.insert(board);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
//		System.out.println(paging.getKeyword());
//		paging.setKeyword(keyword);
		String keyword = paging.getKeyword();
		List<BoardDTO> list = boardService.selectAll(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), boardService.total(keyword)));
//		model.addAttribute("keyword", keyword);
		return "list";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		Board board = new Board();
		if(!dto.getFile().isEmpty()) {
			String url = fileUpload(dto.getFile());
			board.setUrl(url);
		}
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		boardService.insert(board);
		return "redirect:/view?no="+board.getNo();
	}
	
	@GetMapping("/view")
	public String view(int no, Model model) {
//		Board board = boardService.select(no);
		BoardDTO board = boardService.select(no);
		model.addAttribute("board", board);
		return "view";
	}
	
	@PostMapping("/edit")
	public String edit(BoardDTO dto) {
		Board board = new Board();
		board.setNo(dto.getNo());
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		if(!dto.getFile().isEmpty()) {
			fileDelete(dto.getUrl());
			String url = fileUpload(dto.getFile());
			board.setUrl(url);
		} else {
			board.setUrl(dto.getUrl());
		}
		
		boardService.update(board);
		return "redirect:/view?no="+dto.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		BoardDTO board = boardService.select(no);
		fileDelete(board.getUrl());
		boardService.delete(no);
		return "redirect:/list";
	}
}
