package com.kh.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music implements Comparable<Music>{

	private String artist;
	private String song;
	
	@Override
	public int compareTo(Music m) {
		return this.artist.compareTo(m.artist);
//		return m.artist.compareTo(this.artist); // 내림차
	}
}