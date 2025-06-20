package com.kh.practice.controller;

import java.util.Arrays;

import com.kh.practice.model.RockPaperScissor;

public class RockPaperScissorController {
	RockPaperScissor rpsModel = new RockPaperScissor();
	
	private int computer;
	
	public String randomComputer() {
		// 컴퓨터 0 : 가위, 1 : 바위, 2 : 보
		computer = (int)(Math.random() * 3);
		
		return rpsModel.getRps()[computer];
	}
	
	public int computer() {
		return computer;
	}
	
	// 사용자가 입력한 값으로 인덱스 찾기
	public int userIndex(String input) {
		return Arrays.asList(rpsModel.getRps()).indexOf(input);
	}
	
	// 비긴경우
	public void rpsDraw() {
		rpsModel.setDraw(rpsModel.getDraw()+1);
	}
	
	public void rpsLose() {
		rpsModel.setLose(rpsModel.getLose()+1);
	}
	
	public void rpsWin() {
		rpsModel.setWin(rpsModel.getWin()+1);
	}
	
	public String rpsResult() {
		return "비긴 횟수 : " + rpsModel.getDraw() + ", 진 횟수 : " + rpsModel.getLose() + ", 이긴 횟수 : " + rpsModel.getWin();
	}
	
	public int rpsGame(String input) {
		int result = 0;
		int inputResult = userIndex(input);
		
		if(inputResult - computer == 0) {
    		result = 1;
    		rpsDraw();
    	}else if(inputResult - computer == -1 || inputResult - computer == 2) {
    		result = 2;
    		rpsLose();
    	}else if(inputResult - computer == 1 || inputResult - computer == -2) {
    		result = 3;
    		rpsWin();
    	}
		
		return result;
	}
}	
