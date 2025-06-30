package com.kh.practice3.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import com.kh.practice3.compare.SongAscending;
import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	
	//1. 특정 곡 추가
	public String addList(Music music) {
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
			if(m.getSong().toLowerCase().contains(keyword.toLowerCase())
					||m.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
				songList.add(m);
			}
		}
		return songList;
	}
	
	//4. 특정 곡 수정
	public String updateMusic(Music music, String song2, String artist) {
		for(Music m : list) {
			if(m.equals(music)) {
				for(Music m2 : list) {
					if(m2.getSong().equals(song2) && m2.getArtist().equals(artist)) {
						return "수정되는 내용이 기존 목록에 있어 불가능합니다";
					}
				}
				String exSong = m.getSong();
				String exArtist = m.getArtist();
				list.set(list.indexOf(m), new Music(artist, song2));
				
				return "("+exArtist+" - "+exSong+")의 값이 변경되었습니다.";
			}
		}
		
		return "곡을 수정하지 못했습니다.";
	}
	
	public ArrayList<Music> findList(String song) {
		ArrayList<Music> songList = new ArrayList<>();
		for(Music m : list) {
			if(m.getSong().equals(song)) {
				songList.add(m);
			}
		}
		return songList;
	}
	
	//5. 특정 곡 삭제
	public String removeMusic(Music music) {
		for(Music m : list) {
			if(m.equals(music)) {
				list.remove(m);
				return "("+m.getArtist()+" - "+m.getSong()+")을 삭제했습니다.";
			}
		}
		
		return "삭제할 곡이 없습니다.";
	}
	
	public ArrayList<Music> descArtist(){
		ArrayList<Music> desc = new ArrayList<>();
		desc.addAll(list);
		Collections.sort(desc);
		Collections.reverse(desc);
		return desc;
	}
	
	public ArrayList<Music> ascSong(){
		ArrayList<Music> asc = new ArrayList<>();
		asc.addAll(list);
		Collections.sort(asc, new SongAscending());
		return asc;
	}
}