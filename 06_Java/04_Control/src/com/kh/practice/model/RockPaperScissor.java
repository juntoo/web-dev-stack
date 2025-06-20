package com.kh.practice.model;

import java.util.Arrays;

// 캡슐화 -> Single Responsibility Principle (SRP 원칙) 
public class RockPaperScissor {
	private String rps[] = {"가위", "바위", "보"};
	private int draw = 0;
	private int lose = 0;
	private int win = 0;
	
	public RockPaperScissor() {
		
	}

	public RockPaperScissor(String[] rps, int draw, int lose, int win) {
		this.rps = rps;
		this.draw = draw;
		this.lose = lose;
		this.win = win;
	}

	public String[] getRps() {
		return rps;
	}

	public void setRps(String[] rps) {
		this.rps = rps;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	@Override
	public String toString() {
		return "RockPaperScissor [rps=" + Arrays.toString(rps) + ", draw=" + draw + ", lose=" + lose + ", win=" + win
				+ "]";
	}	
}
