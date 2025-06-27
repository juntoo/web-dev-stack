package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	
	//1. 특정 곡 추가
	public String addList(String song, String artist) {
		Music music = new Music(artist, song);
		for(Music m : list) {
			if(m.equals(music)) return "추가 실패";
		}
		
		list.add(music);
		return "추가 성공";
	}
	
	//2. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list;
	}
	
	//3. 특정 곡 검색
	public ArrayList<Music> searchMusic(String keyword) {
		ArrayList<Music> songList = new ArrayList<>();
		for(Music m : list) {
			if(m.getSong().contains(keyword)||m.getArtist().contains(keyword)) {
				songList.add(m);
			}
		}
		return songList;
	}
	
	//4. 특정 곡 수정
	public String updateMusic(String song, String song2, String artist) {
		for(Music m : list) {
			if(m.getSong().equals(song)) {
				String exArtist = m.getArtist();
				m.setSong(song2);
				m.setArtist(artist);
				return "("+exArtist+" - "+song+")의 값이 변경되었습니다.";
			}
		}
		
		return "곡을 수정하지 못했습니다.";
	}
	
	//5. 특정 곡 삭제
	public String removeMusic(String song) {
		for(Music m : list) {
			if(m.getSong().equals(song)) {
				list.remove(m);
				return "("+m.getArtist()+" - "+m.getSong()+")을 삭제했습니다.";
			}
		}
		
		return "삭제할 곡이 없습니다.";
	}
	
}