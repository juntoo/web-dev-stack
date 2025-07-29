package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {
	
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
		File copyFile = new File("\\\\192.168.0.35\\upload\\"+fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
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
	public String list(Model model) {
		List<BoardDTO> list = boardService.selectAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		Board board = new Board();
		String url = fileUpload(dto.getFile());
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setUrl(url);
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
			String url = fileUpload(dto.getFile());
			board.setUrl(url);
		} else {
			String url2 = boardService.select(dto.getNo()).getUrl();
			board.setUrl(url2);
		}
		
		System.out.println(board);
		boardService.update(board);
		return "redirect:/view?no="+dto.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		boardService.delete(no);
		return "redirect:/list";
	}
}
